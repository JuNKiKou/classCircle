package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 评论的实体类
 *
 * @authorJuN
 * @create2017-04-21 14:46
 */
public class Comment {

    private String id;

    private static final String ID = "id";

    private String content;

    private static final String CONTENT = "content";

    private String user;

    private static final String USER = "user";

    private String time;

    private static final String TIME = "time";

    private boolean isTeacher;

    private String name;

    private static final String NAME = "name";

    private String header;

    private static final String HEADER = "header";

    private Reply reply;

    private static final String REPLY = "reply";

    private String subject;

    private static final String SUBJECT = "subject";

    private boolean power;

    private static final String POWER = "power";

    private String student;

    private static final String STUDENT = "student";

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public Reply getReply() {
        return reply;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isPower() {
        return power;
    }

    public Comment(String id, String content, String user, String time, int isTeacher, String name, String header, Reply reply, String subject, boolean power, String student) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.time = time;
        this.isTeacher = (isTeacher == 0);
        this.name = name;
        this.header = header;
        this.reply = reply;
        this.subject = subject;
        this.power = power;
        this.student = student;
    }

    public static JSONObject fixValues(Comment comment){
        JSONObject object = new JSONObject();
        if (comment.isTeacher()){
            //老师
            object.put(SUBJECT,comment.getSubject());
            object.put(POWER,comment.isPower());
        }else {
            //家长
            object.put(STUDENT,comment.STUDENT);
        }
        object.put(ID,comment.getId());
        object.put(CONTENT,comment.getContent());
        object.put(USER,comment.getUser());
        object.put(TIME,comment.getTime());
        object.put(NAME,comment.getName());
        object.put(HEADER,comment.getHeader());
        object.put(REPLY,Reply.fixValues(comment.getReply()));
        return object;
    }

    public static JSONArray fixValues(Comment[] comments){
        JSONArray array = new JSONArray();
        for (int i = 0; i < comments.length; i++) {
            JSONObject item = fixValues(comments[i]);
            array.put(item);
        }
        return array;
    }


}
