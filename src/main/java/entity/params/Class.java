package entity.params;/**
 * Created by JuN on 2017/4/18.
 */

/**
 * @authorJuN
 * @create2017-04-18 09:16
 * 注入班级参数的实体
 */
public class Class {

    //名称
    private String name;
    //学校编号
    private String school;
    //描述
    private String description;

    public Class(String name, String school, String description) {
        this.name = name;
        this.school = school;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
