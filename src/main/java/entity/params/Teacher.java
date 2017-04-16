package entity.params;/**
 * Created by JuN on 2017/4/16.
 */

/**
 * 注册教师时的参数实体
 *
 * @authorJuN
 * @create2017-04-16 12:02
 */
public class Teacher {
    //姓名
    private String name;
    //性别
    private Boolean sex;
    //学科
    private int subject;
    //电话
    private String phone;
    //密码
    private String password;
    //是否是班主任
    private String is_leader;

    public Teacher(String name, Boolean sex, int subject, String phone, String password, String is_leader) {
        this.name = name;
        this.sex = sex;
        this.subject = subject;
        this.phone = phone;
        this.password = password;
        this.is_leader = is_leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_leader() {
        return is_leader;
    }

    public void setIs_leader(String is_leader) {
        this.is_leader = is_leader;
    }
}
