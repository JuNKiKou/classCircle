package muggle.service;

import entity.params.Notice;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JuN on 2017/4/20.
 */
public interface IAppService {

    public abstract String sendMessage(String user, String content, String type, MultipartFile[] pictures,MultipartFile radio,MultipartFile audio);

    public abstract String deleteMessage(String message);

    public abstract String giveZ(String user,String message);

    public abstract String modifyZ(String user,String message);

    public abstract String comment(String user,String message,String content);

    public abstract String reply(String comment,String content);

    public abstract String loadMessages(String classId,int counts);

    public abstract String loadMessage(String message);


    //2.0

    public abstract String loadContacts(String classId);

    public abstract String addNotice(String user,String classId,String content);

    public abstract String deleteNotice(String notice);

    public abstract String getNotices(String classId);

    public abstract String addNoticeSign(String notice,String user);

    public abstract String addTalk(String from,String to,MultipartFile file,int type,String content);

    public abstract String deleteTalk(String talk);

    public abstract String loadTalks(String user1,String user2,int count);
}

