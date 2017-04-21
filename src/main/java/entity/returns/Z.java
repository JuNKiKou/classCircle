package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 赞的实体
 *
 * @authorJuN
 * @create2017-04-21 15:18
 */
public class Z {

    private int id;

    private static final String ID = "id";

    private String giver;

    private static final String GIVER = "giver";

    private String name;

    private static final String NAME = "name";

    private boolean isTeacher;

    private String subject;

    private static final String SUBJECT = "subject";

    private boolean power;

    private static final String POWER = "power";

    private String student;

    private static final String STUDENT = "student";

    public int getId() {
        return id;
    }

    public String getGiver() {
        return giver;
    }

    public String getName() {
        return name;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isPower() {
        return power;
    }

    public String getStudent() {
        return student;
    }

    public Z(int id, String giver, String name, int isTeacher, String subject, boolean power, String student) {
        this.id = id;
        this.giver = giver;
        this.name = name;
        this.isTeacher = (isTeacher == 0);
        this.subject = subject;
        this.power = power;
        this.student = student;
    }

    public static JSONObject fixValues(Z z){
        JSONObject object = new JSONObject();
        if (z.isTeacher()){
            object.put(SUBJECT,z.getSubject());
            object.put(POWER,z.isPower());
        }else {
            object.put(STUDENT,z.getStudent());
        }
        object.put(ID,z.getId());
        object.put(GIVER,z.getGiver());
        object.put(NAME,z.getName());
        return object;
    }

    public static JSONArray fixValues(Z[] zs){
        JSONArray array = new JSONArray();
        for (int i = 0; i < zs.length; i++) {
            JSONObject item = fixValues(zs[i]);
            array.put(item);
        }
        return array;
    }

}
