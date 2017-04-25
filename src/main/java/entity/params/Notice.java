package entity.params;/**
 * Created by JuN on 2017/4/25.
 */

/**
 * 公告的实体参数
 *
 * @authorJuN
 * @create2017-04-25 11:57
 */
public class Notice {

    private String user;

    private String classId;

    private String content;

    public Notice(String user, String classId, String content) {
        this.user = user;
        this.classId = classId;
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
