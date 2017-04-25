package muggle.dao;

import entity.params.Notice;

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

    //2.0


    public abstract String loadContacts(String classId);

    public abstract String addNotice(Notice notice);

    public abstract String deleteNotice(String notice);

    public abstract String getNotices(String classId);

    public abstract String addNoticeSign(String notice,String user);

}
