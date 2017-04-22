package entity.returns;/**
 * Created by JuN on 2017/4/22.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 学校实体类
 *
 * @authorJuN
 * @create2017-04-22 09:05
 */
public class School {

    private static final String ID = "id";

    private String id;

    private static final String NAME = "name";

    private String name;

    private static final String TYPE = "type";

    private int type;

    private static final String AREA = "area";

    private String area;

    public static JSONObject fixValues(School school){
        JSONObject object = new JSONObject();
        object.put(ID,school.getId());
        object.put(NAME,school.getName());
        object.put(TYPE,school.getType());
        object.put(AREA,school.getArea());
        return object;
    }

    public static JSONArray fixValues(School[] schools){
        JSONArray array = new JSONArray();
        for (int i = 0; i < schools.length; i++) {
            JSONObject item = fixValues(schools[i]);
            array.put(item);
        }
        return array;
    }

    public School(String id, String name, int type, String area) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getArea() {
        return area;
    }
}
