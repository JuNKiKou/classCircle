package muggle.service;


/**
 * Created by JuN on 2017/4/17.
 */
public interface IWebService {

    public abstract String registerTeacher(String name,boolean sex,int subject,String phone,String password,boolean leader);

    public abstract String registerParent(String name,boolean sex,String phone,String password, String studentId);


}
