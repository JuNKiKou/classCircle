package muggle.constant;/**
 * Created by JuN on 2017/4/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * json对象中的返回码
 *
 * @authorJuN
 * @create2017-04-17 09:23
 */
public class JSONValue {

    public static final String SUCCESS = "操作成功";

    public static final String SQL_PROCEDURE_EXECUTE_EXCEPTION = "存储过程执行异常";

    public static final String SQL_LOGIN_NO_SUCH_USER = "没用这样的用户";

    public static final String SQL_LOGIN_PWD_ERROR = "密码错误";

    public static final String SQL_LOGIN_TEACHER_SUCCESS = "教师登录成功";

    public static final String SQL_LOGIN_PARENT_SUCCESS = "家长登录成功";

    public static final String SQL_REGISTER_USER_EXISTS = "用户已存在";

    public static final String SQL_REGISTER_BIND_ERROR = "绑定失败";

    public static final String SQL_ADD_CLASS_EXISTS = "该班级已存在";

    public static final String SQL_MODIFY_CLASS_ERROR = "修改班级信息失败";

    public static final String SQL_UNBIND_LEADER_EXCEPTION = "解除班主任是失败";

    public static final String SQL_MODIFY_STUDENT_ERROR = "修改学生信息出错";

    public static final String SQL_CUT_STUDENT_ERROR = "踢出学生出错";

    public static final String FILE_UPLOAD_ERROR = "文件上传失败";

    public static final String SEND_MESSAGE_ERROR = "推送消息错误";

    public static final String DELETE_MESSAGE_ERROR = "删除消息出错";

    public static final String GIVE_Z_ERROR = "点赞失败";

    public static final String MODIFY_Z_ERROR = "改赞失败";

    public static final String COMMENT_ERROR = "评论失败";

    public static final String REPLY_ERROR = "回复失败";

    public static final String SEARCH_CLASS_ERROR = "查询班级失败";

    public static final String LOAD_MESSAGE_ERROR = "获取消息失败";

    private static Map<String,Integer> instance = new HashMap<String, Integer>();



    static {
        instance.put(SQL_PROCEDURE_EXECUTE_EXCEPTION,100);
        instance.put(SQL_LOGIN_NO_SUCH_USER,201);
        instance.put(SQL_LOGIN_PWD_ERROR,202);
        instance.put(SQL_LOGIN_TEACHER_SUCCESS,203);
        instance.put(SQL_LOGIN_PARENT_SUCCESS,204);
        instance.put(SQL_REGISTER_USER_EXISTS,205);
        instance.put(SQL_REGISTER_BIND_ERROR,206);
        instance.put(SQL_MODIFY_CLASS_ERROR,207);
        instance.put(SQL_ADD_CLASS_EXISTS,208);
        instance.put(SQL_UNBIND_LEADER_EXCEPTION,209);
        instance.put(SQL_MODIFY_STUDENT_ERROR,210);
        instance.put(SQL_CUT_STUDENT_ERROR,211);
        instance.put(FILE_UPLOAD_ERROR,301);
        instance.put(SEND_MESSAGE_ERROR,401);
        instance.put(DELETE_MESSAGE_ERROR,402);
        instance.put(GIVE_Z_ERROR,403);
        instance.put(MODIFY_Z_ERROR,404);
        instance.put(REPLY_ERROR,405);
        instance.put(SUCCESS,500);
        instance.put(SEARCH_CLASS_ERROR,501);
        instance.put(LOAD_MESSAGE_ERROR,502);
    }


    public static int get(String key){
        return instance.get(key);
    }
}
