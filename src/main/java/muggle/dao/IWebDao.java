package muggle.dao;

import entity.params.Class;
import entity.params.Parent;
import entity.params.Teacher;

/**
 * web端的数据库事务
 * Created by JuN on 2017/4/17.
 */
public interface IWebDao {


    public abstract String registerTeacher(Teacher teacher);

    public abstract String registerParent(Parent parent, String studentId);

    public abstract String addClass(Class c,String leader);

    public abstract String modifyClass(String classId,String param,int type);

    public abstract String deleteClass(String classId);

    public abstract String unbindLeader(String classId);

    public abstract String addStudent(String name,boolean sex,String classId);

    public abstract String modifyStudent(String studentId,String param,int type);

    public abstract String cutStudent(String studentId);

    public abstract String studentBindClass(String studentId,String classId);

    public abstract String modifyUser(String userId,String param,int type);

}
