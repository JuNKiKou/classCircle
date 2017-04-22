package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 学生实体类
 *
 * @authorJuN
 * @create2017-04-21 20:15
 */
public class Student {

    private static final String ID = "id";

    private String id;

    private static final String NAME = "name";

    private String name;

    private static final String SEX = "sex";

    private boolean sex;

    public Student(String id, String name, boolean sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public static JSONObject fixValues(Student student){
        JSONObject object = new JSONObject();
        object.put(ID,student.getId());
        object.put(NAME,student.getName());
        object.put(SEX,student.isSex());
        return object;
    }

    public static JSONArray fixValues(Student[] students){
        JSONArray array = new JSONArray();
        for (int i = 0; i < students.length; i++) {
            JSONObject item = fixValues(students[i]);
            array.put(item);
        }
        return array;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }
}
