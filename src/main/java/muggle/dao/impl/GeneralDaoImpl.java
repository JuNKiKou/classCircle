package muggle.dao.impl;/**
 * Created by JuN on 2017/4/16.
 */

import entity.params.Parent;
import entity.params.Teacher;
import muggle.dao.GeneralDao;
import muggle.dao.unit.DBUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @authorJuN
 * @create2017-04-16 12:30
 */
@Repository
public class GeneralDaoImpl implements GeneralDao{

    @Autowired
    private DBUnit unit;

    public String login(String phone, String password) {
        return null;
    }

    public String registerTeacher(Teacher teacher) {
        return null;
    }

    public String registerParent(Parent parent, String studentId) {
        return null;
    }
}
