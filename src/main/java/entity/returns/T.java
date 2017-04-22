package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableServer.POAHelper;

/**
 * @authorJuN
 * @create2017-04-21 20:05
 */
public class T {

    private static final String ID = "id";

    private String id;

    private static final String NAME = "name";

    private String name;

    private static final String HEADER = "header";

    private String header;

    private static final String SUBJECT = "subject";

    private String subject;

    private static final String TELEPHONE = "phone";

    private String phone;

    private static final String POWER = "power";

    private boolean power;

    public T(String id, String name, String header, String subject, String phone, boolean power) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.subject = subject;
        this.phone = phone;
        this.power = power;
    }

    public static JSONObject fixValues(T t){
        JSONObject object = new JSONObject();
        object.put(ID,t.getId());
        object.put(NAME,t.getName());
        object.put(HEADER,t.getHeader());
        object.put(SUBJECT,t.getSubject());
        object.put(TELEPHONE,t.getPhone());
        object.put(POWER,t.isPower());
        return object;
    }

    public static JSONArray fixValues(T[] ts){
        JSONArray array = new JSONArray();
        for (int i = 0; i < ts.length; i++) {
            JSONObject item = fixValues(ts[i]);
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

    public String getHeader() {
        return header;
    }

    public String getSubject() {
        return subject;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isPower() {
        return power;
    }
}
