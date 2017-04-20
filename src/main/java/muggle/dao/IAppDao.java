package muggle.dao;

/**
 * Created by JuN on 2017/4/17.
 */
public interface IAppDao {

    public abstract String sendMessage(String user, String content,String path,String type);

    public abstract String deleteMessage(String message);

}
