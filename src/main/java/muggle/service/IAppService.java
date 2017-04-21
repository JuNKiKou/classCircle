package muggle.service;

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
}

