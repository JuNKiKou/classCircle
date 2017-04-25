package entity.returns;/**
 * Created by JuN on 2017/4/25.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 聊天记录实体类
 *
 * @authorJuN
 * @create2017-04-25 16:33
 */
public class Talk {

    private static final String ID = "id";

    private String id;

    private static final String SENDER = "sender";

    private String sender;

    private static final String PATH = "path";

    private String path;

    private static final String CONTENT = "content";

    private String content;

    private static final String TIME = "time";

    private String time;

    public static JSONObject fixValues(Talk talk){
        JSONObject object = new JSONObject();
        object.put(ID,talk.getId());
        object.put(SENDER,talk.getSender());
        if (!isNull(talk.getPath())){
            object.put(PATH,talk.getPath());
        }
        if (!isNull(talk.getContent())){
            object.put(CONTENT,talk.getContent());
        }
        object.put(TIME,talk.getTime());
        return object;
    }

    public static JSONArray fixValues(Talk[] talks){
        JSONArray array = new JSONArray();
        for (int i = 0; i < talks.length; i++) {
            JSONObject item = fixValues(talks[i]);
            array.put(item);
        }
        return array;
    }

    public Talk(String id,String sender, String path, String content, String time) {
        this.id = id;
        this.sender = sender;
        this.path = path;
        this.content = content;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getPath() {
        return path;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    private static boolean isNull(String str){
        if (str == null || str.equals("")){
            return true;
        }
        return false;
    }
}
