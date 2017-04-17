package muggle.dao.impl;/**
 * Created by JuN on 2017/4/16.
 */

import entity.params.Parent;
import entity.params.Teacher;
import muggle.constant.Exception;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import muggle.constant.SQL;
import muggle.dao.IGeneralDao;
import muggle.helper.Out;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * @authorJuN
 * @create2017-04-16 12:30
 */
@Repository
public class GeneralDaoImpl extends BaseDaoImpl implements IGeneralDao {


    public String login(String phone, String password) {
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();
        String sql = SQL.PROCEDURE_LOGIN;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,phone);
            statement.setString(2,password);
            statement.registerOutParameter(3, Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            switch (code){
                case -2:
                    //用户不存在
                    resultCode = JSONValue.get(JSONValue.SQL_LOGIN_NO_SUCH_USER);
                    break;
                case -1:
                    //账号密码错误
                    resultCode = JSONValue.get(JSONValue.SQL_LOGIN_PWD_ERROR);
                    break;
                case 1:
                    //教师登录成功
                    resultCode = JSONValue.get(JSONValue.SQL_LOGIN_TEACHER_SUCCESS);
                    ResultSet set = statement.getResultSet();
                    while (set != null && set.next()){
                        entity.returns.Teacher teacher = new entity.returns.Teacher(
                               set.getString(1),
                               set.getInt(2),
                               set.getString(3),
                               set.getBoolean(4),
                               set.getInt(5),
                               cutNull(set.getString(6)),
                               cutNull(set.getString(7))
                        );
                        entity.returns.Teacher.fixValues(result,teacher);
                    }
                    set.close();
                    break;
                case 2:
                    //家长登录成功
                    resultCode = JSONValue.get(JSONValue.SQL_LOGIN_PARENT_SUCCESS);
                    ResultSet rs = statement.getResultSet();
                    while (rs != null && rs.next()){
                        entity.returns.Parent parent = new entity.returns.Parent(
                                rs.getString(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getBoolean(4),
                                cutNull(rs.getString(5)),
                                cutNull(rs.getString(6))
                        );
                        entity.returns.Parent.fixValues(result,parent);
                    }
                    rs.close();
                    break;
                default:
                    break;
            }
            statement.close();
        } catch (SQLException e) {
            Out.print(Exception.SQL_EXECUTE_EXCEPTION);
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }finally {
            getUnit().closeConnection(connection);
        }

        result.put(JSONKey.RESULT_CODE,resultCode);
        return result.toString();
    }

    private String cutNull(String str){
        return str != null ? str : "";
    }
}
