package entity.returns;/**
 * Created by JuN on 2017/4/25.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 公告的实体
 *
 * @authorJuN
 * @create2017-04-25 12:34
 */
public class Notice {

    private static final String ID = "id";

    private String id;

    private static final String USER = "user";

    private String user;

    private static final String CONTENT = "content";

    private String content;

    private static final String TIME = "time";

    private String time;

    private static final String HEADER = "header";

    private String header;

    private static final String SUBJECT = "subject";

    private String subject;

    private static final String POWER = "power";

    private boolean power;

    private static final String REACH = "reach";

    private int reach;

    private static final String COUNTS = "counts";

    private int counts;

    public static JSONObject fixValues(Notice notice){
        JSONObject object = new JSONObject();
        object.put(ID,notice.getId());
        object.put(USER,notice.getUser());
        object.put(CONTENT,notice.getContent());
        object.put(TIME,notice.getTime());
        object.put(HEADER,notice.getHeader());
        object.put(SUBJECT,notice.getSubject());
        object.put(POWER,notice.isPower());
        object.put(REACH,notice.getReach());
        object.put(COUNTS,notice.getCounts());
        return object;
    }

    public static JSONArray fixValues(Notice[] notices){
        JSONArray array = new JSONArray();
        for (int i = 0; i < notices.length; i++) {
            JSONObject item = fixValues(notices[i]);
            array.put(item);
        }
        return array;
    }

    public Notice(String id, String user, String content, String time, String header, String subject, boolean power, int reach, int counts) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.time = time;
        this.header = header;
        this.subject = subject;
        this.power = power;
        this.reach = reach;
        this.counts = counts;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getHeader() {
        return header;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isPower() {
        return power;
    }

    public int getReach() {
        return reach;
    }

    public int getCounts() {
        return counts;
    }
}
