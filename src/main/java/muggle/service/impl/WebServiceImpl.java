package muggle.service.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Class;
import entity.params.Parent;
import entity.params.Teacher;
import muggle.dao.IWebDao;
import muggle.service.IWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authorJuN
 * @create2017-04-17 19:37
 */
@Service
public class WebServiceImpl implements IWebService{

    @Autowired
    private IWebDao dao;

    public String registerTeacher(String name, boolean sex, int subject, String phone, String password, boolean leader) {
        Teacher teacher = new Teacher(name,sex,subject,phone,password,leader);
        return dao.registerTeacher(teacher);
    }

    public String registerParent(String name, boolean sex, String phone, String password, String studentId) {
        Parent parent = new Parent(name,sex,phone,password);
        return dao.registerParent(parent,studentId);
    }

    public String addClass(String name, String school, String description, String leader) {
        Class c = new Class(name,school,description);
        return dao.addClass(c,leader);
    }
}
