package muggle.dao.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Parent;
import entity.params.Teacher;
import muggle.constant.*;
import muggle.constant.Exception;
import muggle.dao.IWebDao;
import muggle.helper.IDUtil;
import muggle.helper.Out;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * @authorJuN
 * @create2017-04-17 16:12
 */
@Repository
public class WebDaoImpl extends BaseDaoImpl implements IWebDao{

    public String registerTeacher(Teacher teacher) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        //获取教师表的id
        String sql = SQL.PROCEDURE_GET_TEACHERID;
        String teacherId = IDUtil.getId(connection,sql, IdHeaders.TEACHER_HEADER,16);

        //获取用户Id
        sql = SQL.PROCEDURE_GET_USERID;
        String userId = IDUtil.getId(connection,sql,IdHeaders.USER_HEADER,16);

        //注册教师
        sql = SQL.PROCEDURE_REGISTER_TEACHER;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,teacherId);
            statement.setString(2,userId);
            statement.setString(3,teacher.getName());
            statement.setBoolean(4,teacher.getSex());
            statement.setInt(5,teacher.getSubject());
            statement.setString(6,teacher.getPhone());
            statement.setString(7,teacher.getPassword());
            statement.setBoolean(8,teacher.getIs_leader());
            statement.registerOutParameter(9, Types.INTEGER);
            statement.execute();
            int code = statement.getInt(9);
            if (code == -1){
                resultCode = JSONValue.get(JSONValue.SQL_REGISTER_USER_EXISTS);
            }else if (code == 1){
                result.put(JSONKey.USER_ID,userId);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            Out.print(Exception.SQL_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }finally {
            getUnit().closeConnection(connection);
        }

        result.put(JSONKey.RESULT_CODE,resultCode);

        return result.toString();

    }

    public String registerParent(Parent parent, String studentId) {
        return null;
    }
}
