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

//    public abstract String modifyClass(String classId,String param,int type);

}
