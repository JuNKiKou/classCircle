package muggle.service.impl;/**
 * Created by JuN on 2017/4/20.
 */

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

    private String dealMedia(MultipartFile file, String path){
        String str = null;
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