package entity.returns;/**
 * Created by JuN on 2017/4/22.
 */

import org.json.JSONArray;
import org.json.JSONObject;

import javax.print.attribute.standard.MediaSize;

/**
 * 学科实体类
 *
 * @authorJuN
 * @create2017-04-22 09:05
 */
public class Subject {

    private static final String ID = "id";

    private int id ;

    private static final String NAME = "name";

    private String name;

    public static JSONObject fixValues(Subject subject){
        JSONObject object = new JSONObject();
        object.put(ID,subject.getId());
        object.put(NAME,subject.getName());
        return object;
    }

    public static JSONArray fixValues(Subject[] subjects){
        JSONArray array = new JSONArray();
        for (int i = 0; i < subjects.length; i++) {
            JSONObject item = fixValues(subjects[i]);
            array.put(item);
        }
        return array;
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
