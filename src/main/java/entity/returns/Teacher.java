package entity.returns;/**
 * Created by JuN on 2017/4/17.
 */

import org.json.JSONObject;

/**
 * 返回的教师信息对象
 *
 * @authorJuN
 * @create2017-04-17 10:12
 */
public class Teacher {

    private static final String USER = "user";

    private static final String TYPE = "type";

    private static final String NAME = "name";

    private static final String SEX = "sex";

    private static final String SUBJECT = "subject";

    private static final String HEADER = "header";

    private static final String INDEX = "index";




    //用户编号
    private String user ;
    //类型，教师或者家长
    private int type;
    //姓名
    private String name;
    //性别
    private boolean sex;
    //学科
    private int subject;
    //头像
    private String header;
    //封面
    private String index;

    public Teacher(String user, int type, String name, boolean sex, int subject, String header, String index) {
        this.user = user;
        this.type = type;
        this.name = name;
        this.sex = sex;
        this.subject = subject;
        this.header = header;
        this.index = index;
    }


    public static void fixValues(JSONObject object,Teacher teacher){
        object.put(USER,teacher.getUser());
        object.put(TYPE,teacher.getType());
        object.put(NAME,teacher.getName());
        object.put(SEX,teacher.isSex());
        object.put(SUBJECT,teacher.getSubject());
        object.put(HEADER,teacher.getHeader());
        object.put(INDEX,teacher.getIndex());
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
