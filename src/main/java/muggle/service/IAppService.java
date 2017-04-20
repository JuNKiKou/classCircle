package muggle.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JuN on 2017/4/20.
 */
public interface IAppService {

    public abstract String sendMessage(String user, String content, String type, MultipartFile[] pictures,MultipartFile radio,MultipartFile audio);

    public abstract String deleteMessage(String message);
}
