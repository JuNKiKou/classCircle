package muggle.dao;

/**
 * Created by JuN on 2017/4/17.
 */
public interface IAppDao {

    public abstract String sendMessage(String user, String content,String path,String type);

    public abstract String deleteMessage(String message);

    public abstract String giveZ(String user,String message);

    public abstract String modifyZ(String user,String message);

    public abstract String comment(String user,String message,String content);

    public abstract String reply(String comment,String content);

    //获取所有message的粗略信息
    public abstract String loadMessages(String classId,int counts);
    //获取单条message的详细信息
    public abstract String loadMessage(String message);

}
