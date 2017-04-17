package muggle.dao;

import entity.params.Parent;
import entity.params.Teacher;

/**
 * Created by JuN on 2017/4/16.
 */
public interface IGeneralDao {

    public abstract String login(String phone,String password);

    public abstract String registerTeacher(Teacher teacher);

    public abstract String registerParent(Parent parent,String studentId);

}
