package muggle.service.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Class;
import entity.params.Parent;
import entity.params.Teacher;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import muggle.constant.Path;
import muggle.dao.IWebDao;
import muggle.helper.LoadHelper;
import muggle.service.IWebService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public String modifyClass(String classId, String param, int type) {
        return dao.modifyClass(classId,param,type);
    }

    public String deleteClass(String classId) {
        return dao.deleteClass(classId);
    }

    public String unbindLeader(String classId) {
        return dao.unbindLeader(classId);
    }

    public String addStudent(String name, boolean sex, String classId) {
        return dao.addStudent(name,sex,classId);
    }

    public String modifyStudent(String studentId, String param, int type) {
        return dao.modifyStudent(studentId,param,type);
    }

    public String cutStudent(String studentId) {
        return dao.cutStudent(studentId);
    }

    public String studentBindClass(String studentId, String classId) {
        return dao.studentBindClass(studentId,classId);
    }

    public String modifyUserInfo(String user, String param, int type) {
        return dao.modifyUser(user,param,type);
    }

    public String modifyUserInfo(String user, int type, MultipartFile file) {
        String rootDir = null;
        int resultCode;
        if (type == 2){
            rootDir = Path.USER_HEADER_SAVE_DIR;
        }else if (type == 3){
            rootDir = Path.USER_INDEX_SAVE_DIR;
        }
        String result = LoadHelper.uploadFile(file,rootDir);
        JSONObject object = new JSONObject(result);
        resultCode = object.getInt(JSONKey.RESULT_CODE);
        if (resultCode == JSONValue.get(JSONValue.SUCCESS)){
            String path = object.getString(JSONKey.FILE_PATH);
            return dao.modifyUser(user,path,type);
        }
        return result;
    }

    public String searchClass(String keyword) {
        return dao.searchClass(keyword);
    }

    public String getClassInfo(String classId) {
        return dao.getClassInfo(classId);
    }
}
