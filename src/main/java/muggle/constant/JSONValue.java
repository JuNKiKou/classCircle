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

    private static Map<String,Integer> instance = new HashMap<String, Integer>();



    static {
        instance.put(SQL_PROCEDURE_EXECUTE_EXCEPTION,100);
        instance.put(SQL_LOGIN_NO_SUCH_USER,201);
        instance.put(SQL_LOGIN_PWD_ERROR,202);
        instance.put(SQL_LOGIN_TEACHER_SUCCESS,203);
        instance.put(SQL_LOGIN_PARENT_SUCCESS,204);
        instance.put(SUCCESS,500);
    }


    public static int get(String key){
        return instance.get(key);
    }
}
