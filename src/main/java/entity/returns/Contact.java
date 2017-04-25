package entity.returns;/**
 * Created by JuN on 2017/4/25.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 联系人实体
 *
 * @authorJuN
 * @create2017-04-25 10:38
 */
public class Contact {

    private static final String ID = "id";

    private String id;

    private static final String NAME = "name";

    private String name;

    private static final String HEADER = "header";

    private String header;

    private static final String ISTEACHER = "isTeacher";

    private boolean isTeacher;

    private static final String SUBJECT = "subject";

    private String subject;

    private static final String POWER = "power";

    private boolean power;

    private static final String STUDENT = "student";

    private String student;

    public static JSONObject fixValues(Contact contact){
        JSONObject object = new JSONObject();
        object.put(ID,contact.getId());
        object.put(NAME,contact.getName());
        object.put(HEADER,contact.getHeader());
        object.put(ISTEACHER,contact.isTeacher());
        object.put(SUBJECT,contact.getSubject());
        object.put(POWER,contact.isPower());
        object.put(STUDENT,contact.getStudent());
        return object;
    }

    public static JSONArray fixValues(Contact[] contacts){
        JSONArray array = new JSONArray();
        for (int i = 0; i < contacts.length; i++) {
            JSONObject item = fixValues(contacts[i]);
            array.put(item);
        }
        return array;
    }

    public Contact(String id, String name, String header, boolean isTeacher, String subject, boolean power, String student) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.isTeacher = isTeacher;
        this.subject = subject;
        this.power = power;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
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
}
