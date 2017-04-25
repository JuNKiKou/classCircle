package muggle.service.impl;/**
 * Created by JuN on 2017/4/20.
 */

import com.sun.tools.corba.se.idl.constExpr.Not;
import entity.params.Notice;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import muggle.constant.Path;
import muggle.dao.IAppDao;
import muggle.helper.LoadHelper;
import muggle.helper.PathHelper;
import muggle.service.IAppService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * app 服务实现类
 *
 * @authorJuN
 * @create2017-04-20 11:55
 */
@Service
public class AppServiceImpl implements IAppService{

    @Autowired
    private IAppDao dao;

    public String sendMessage(String user, String content, String type, MultipartFile[] pictures, MultipartFile radio, MultipartFile audio) {
        boolean success = true;
        boolean flag = false;//前面是否有值
        StringBuilder builder = new StringBuilder();
        String text;
        if (type.contains("A")){
            //文字
            text = content;
        }else {
            text = "";
        }
        if (type.contains("B")){
            //语音 audio
            String audioResult = dealMedia(audio,Path.MESSAGE_AUDIO_SAVE_DIR);
            if (audioResult.equals("")){
                success = false;
            }
            if (success){
                audioResult = PathHelper.addAudio(audioResult);
                builder.append(audioResult);
                flag = true;
            }
        }
        if (type.contains("C")){
            //图片
            String photo;
            String[] picturesPaths = new String[pictures.length];
            for (int i = 0; i < picturesPaths.length; i++) {
                photo = dealMedia(pictures[i],Path.MESSAGE_PHOTO_SAVE_DIR);
                if (photo.equals("")){
                    success = false;
                }
                picturesPaths[i] = photo;
            }
            if (success){
                String photoResult = PathHelper.addPictures(picturesPaths);
                if (flag){
                    builder.append(PathHelper.SPACE_TYPE);
                }
                builder.append(photoResult);
                flag = true;
            }
        }
        if (type.contains("D")){
            //视频
            String radioResult = dealMedia(radio,Path.MESSAGE_RADIO_SAVE_DIR);
            if (radioResult.equals("")){
                success = false;
            }

            if (success){
                radioResult = PathHelper.addRadio(radioResult);
                if (flag){
                    builder.append(PathHelper.SPACE_TYPE);
                }
                builder.append(radioResult);
            }
        }

        return dao.sendMessage(user,text,builder.toString(),type);
    }

    public String deleteMessage(String message) {
        return dao.deleteMessage(message);
    }

    public String giveZ(String user, String message) {
        return dao.giveZ(user,message);
    }

    public String modifyZ(String user, String message) {
        return dao.modifyZ(user,message);
    }

    public String comment(String user, String message, String content) {
        return dao.comment(user,message,content);
    }

    public String reply(String comment, String content) {
        return dao.reply(comment,content);
    }

    public String loadMessages(String classId, int counts) {
        return dao.loadMessages(classId,counts);
    }

    public String loadMessage(String message) {
        return dao.loadMessage(message);
    }

    public String loadContacts(String classId) {
        return dao.loadContacts(classId);
    }

    public String addNotice(String user,String classId,String content) {
        Notice notice = new Notice(user,classId,content);
        return dao.addNotice(notice);
    }

    public String deleteNotice(String notice) {
        return dao.deleteNotice(notice);
    }

    public String addNoticeSign(String notice, String user) {
        return dao.addNoticeSign(notice,user);
    }

    public String getNotices(String classId) {
        return dao.getNotices(classId);
    }

    public String addTalk(String from, String to, MultipartFile file,int type,String content) {
        String savePath = null;
        switch (type){
            case 0:
                savePath = Path.MESSAGE_AUDIO_SAVE_DIR;
                break;
            case 1:
                savePath = Path.MESSAGE_PHOTO_SAVE_DIR;
                break;
            case 2:
                savePath = Path.MESSAGE_RADIO_SAVE_DIR;
                break;
            default:
                break;
        }
        String path = dealMedia(file,savePath);

        return dao.addTalk(from,to,path,content);
    }

    public String deleteTalk(String talk) {
        return dao.deleteTalk(talk);
    }

    public String loadTalks(String user1, String user2, int count) {
        return dao.loadTalks(user1,user2,count);
    }

    private String dealMedia(MultipartFile file, String path){
        if (path == null || path.equals("")){
            return "";
        }
        String str;
        String result = LoadHelper.uploadFile(file, path);
        JSONObject object = new JSONObject(result);
        int code = object.getInt(JSONKey.RESULT_CODE);
        if (code == JSONValue.get(JSONValue.SUCCESS)){
            str = object.getString(JSONKey.FILE_PATH);
        }else {
            str = "";
        }
        return str;
    }
}
