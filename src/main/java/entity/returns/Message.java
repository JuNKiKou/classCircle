package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import muggle.helper.PathHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 消息对象实体
 *
 * @authorJuN
 * @create2017-04-21 14:19
 */
public class Message {

    private String id;

    private static final String ID = "id";

    private String type;

    private static final String TYPE = "type";

    private String sender;

    private static final String SENDER = "sender";

    private String content;

    private static final String CONTENT = "content";

    private String path;

    private static final String PATH = "path";

    private String time;

    private static final String TIME = "time";

    private boolean isTeacher;

    private String senderName;

    private static final String SENDERNAME = "sendName";

    private String sendHeader;

    private static final String HEADER = "header";

    private String subject;

    private static final String SUBJECT = "subject";

    private boolean power;

    private static final String POWER = "power";

    private String student;

    private static final String STUDENT = "student";

    private Comment[] comments;

    private static final String COMMENTS = "comments";

    private boolean comment_more;

    private static final String COMMENT_MORE = "cm";

    private boolean z_more;

    private static final String Z_MORE = "zm";

    private Z[] zs;

    private static final String ZS = "zs";

    public boolean isComment_more() {
        return comment_more;
    }

    public void setComment_more(boolean comment_more) {
        this.comment_more = comment_more;
    }

    public boolean isZ_more() {
        return z_more;
    }

    public void setZ_more(boolean z_more) {
        this.z_more = z_more;
    }

    public Z[] getZs() {
        return zs;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public void setZs(Z[] zs) {
        this.zs = zs;
    }

    public Message(String id, String type, String sender, String content, String path, String time, int isTeacher, String senderName, String sendHeader, String subject, boolean power, String student) {
        this.id = id;
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.path = path;
        this.time = time;
        this.isTeacher = (isTeacher == 0);
        this.senderName = senderName;
        this.sendHeader = sendHeader;
        this.subject = subject;
        this.power = power;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }

    public String getTime() {
        return time;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSendHeader() {
        return sendHeader;
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

    public Comment[] getComments() {
        return comments;
    }

    public static JSONObject fixValues(Message message){
        JSONObject object = new JSONObject();
        if (message.isTeacher()){
            object.put(SUBJECT,message.getSubject());
            object.put(POWER,message.isPower());
        }else {
            object.put(STUDENT,message.getStudent());
        }
        object.put(ID,message.getId());
        object.put(TYPE,message.getType());
        object.put(SENDER,message.getSender());
        object.put(CONTENT,message.getContent());
        object.put(PATH, new JSONObject(PathHelper.releasePath(message.getPath())));
        object.put(TIME,message.getTime());
        object.put(SENDERNAME,message.getSenderName());
        object.put(HEADER,message.getSendHeader());
        object.put(COMMENTS,Comment.fixValues(message.getComments()));
        object.put(ZS,Z.fixValues(message.getZs()));
        object.put(COMMENT_MORE,message.isComment_more());
        object.put(Z_MORE,message.isZ_more());
        return object;
    }

    public static JSONArray fixValues(Message[] messages){
        JSONArray array = new JSONArray();
        for (int i = 0; i < messages.length; i++) {
            JSONObject item = fixValues(messages[i]);
            array.put(item);
        }
        return array;
    }
}
