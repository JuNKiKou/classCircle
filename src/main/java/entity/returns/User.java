package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import muggle.constant.JSONKey;
import org.json.JSONObject;

/**
 * 用户信息的实体类
 *
 * @authorJuN
 * @create2017-04-21 18:49
 */
public class User {

    private boolean isTeacher;

    private static final String NAME = "name";

    private String name;

    private static final String SEX = "sex";

    private boolean sex;

    private static final String PHONE = "phone";

    private String telephone;

    private static final String SUBJECT = "subject";

    private String subject;

    private static final String POWER = "power";

    private boolean power;

    private static final String HEADER = "header";

    private String header;

    private static final String INDEX = "index";

    private String index;

    private static final String CLASS = "class";

    private String classId;

    private static final String CLASS_NAME = "className";

    private String className;

    private static final String SCHOOLNAME = "schoolName";

    private String schoolName;

    private static final String SCHOOLAREA = "schoolArea";

    private static final String STUDENT = "student";

    private String student;

    private String schoolArea;

    public String getStudent() {
        return student;
    }

    public User(int isTeacher, String name, boolean sex, String telephone, String subject, boolean power, String header, String index, String classId, String className, String schoolName, String schoolArea,String student) {
        this.isTeacher = (isTeacher == 0);
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
        this.subject = subject;
        this.power = power;
        this.header = header;
        this.index = index;
        this.classId = classId;
        this.className = className;
        this.schoolName = schoolName;
        this.schoolArea = schoolArea;
        this.student = student;
    }

    public static JSONObject fixValues(User user){
        JSONObject object = new JSONObject();
        if (user.isTeacher()){
            object.put(SUBJECT,user.getSubject());
            object.put(POWER,user.isPower());
        }else {
            object.put(STUDENT,user.getStudent());
        }
        object.put(NAME,user.getName());
        object.put(SEX,user.isSex());
        object.put(PHONE,user.getTelephone());
        object.put(HEADER,user.getHeader());
        object.put(INDEX,user.getIndex());
        object.put(CLASS,user.getClassId());
        object.put(CLASS_NAME,user.getClassName());
        object.put(SCHOOLNAME,user.getSchoolName());
        object.put(SCHOOLAREA,user.getSchoolArea());
        return object;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isPower() {
        return power;
    }

    public String getHeader() {
        return header;
    }

    public String getIndex() {
        return index;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolArea() {
        return schoolArea;
    }
}
