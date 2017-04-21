package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import org.json.JSONObject;

/**
 * 回复的实体类
 *
 * @authorJuN
 * @create2017-04-21 14:46
 */
public class Reply {

    private String id;

    private static final String ID = "id";

    private String content;

    private static final String CONTENT = "content";

    private String time;

    private static final String TIME = "time";

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public Reply(String id, String content, String time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

    public static JSONObject fixValues(Reply reply){
        JSONObject object = new JSONObject();
        object.put(ID,reply.getId());
        object.put(CONTENT,reply.getContent());
        object.put(TIME,reply.getTime());
        return object;
    }
}
