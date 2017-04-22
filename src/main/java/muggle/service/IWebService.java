package muggle.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * Created by JuN on 2017/4/17.
 */
public interface IWebService {

    public abstract String registerTeacher(String name,boolean sex,int subject,String phone,String password,boolean leader);

    public abstract String registerParent(String name,boolean sex,String phone,String password, String studentId);

    public abstract String addClass(String name,String school,String description,String leader);

    public abstract String modifyClass(String classId,String param,int type);

    public abstract String deleteClass(String classId);

    public abstract String unbindLeader(String classId);

    public abstract String addStudent(String name,boolean sex,String classId);

    public abstract String modifyStudent(String studentId,String param,int type);

    public abstract String cutStudent(String studentId);

    public abstract String studentBindClass(String studentId,String classId);

    public abstract String modifyUserInfo(String user,String param,int type);

    public abstract String modifyUserInfo(String user, int type, MultipartFile file);

    public abstract String searchClass(String keyword);

    public abstract String getClassInfo(String classId);
}
