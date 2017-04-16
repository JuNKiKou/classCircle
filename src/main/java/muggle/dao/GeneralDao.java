package muggle.dao;

import entity.params.Parent;
import entity.params.Teacher;

/**
 * Created by JuN on 2017/4/16.
 */
public interface GeneralDao {

    public String login(String phone,String password);

    public String registerTeacher(Teacher teacher);

    public String registerParent(Parent parent,String studentId);

}
