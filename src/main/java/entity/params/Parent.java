package entity.params;/**
 * Created by JuN on 2017/4/16.
 */

/**
 * 注册家长时传入的参数的实体
 *
 * @authorJuN
 * @create2017-04-16 12:06
 */
public class Parent {

    private String name;

    private Boolean sex;

    private String phone;

    private String password;

    public Parent(String name, Boolean sex, String phone, String password) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.password = password;
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
}
