package muggle.dao.impl;/**
 * Created by JuN on 2017/4/16.
 */

import entity.params.Parent;
import entity.params.Teacher;
import entity.returns.School;
import entity.returns.Subject;
import entity.returns.User;
import muggle.constant.Exception;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import muggle.constant.SQL;
import muggle.dao.IGeneralDao;
import muggle.helper.Out;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public String getUserInfo(String user) {
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();
        String sql = SQL.PROCEDURE_GET_USER_INFO;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,user);
            statement.registerOutParameter(2,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(2);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    User u = new User(
                            set.getInt(1),
                            set.getString(2),
                            set.getBoolean(3),
                            set.getString(4),
                            set.getString(5),
                            set.getBoolean(6),
                            set.getString(7),
                            set.getString(8),
                            set.getString(9),
                            set.getString(10),
                            set.getString(11),
                            set.getString(12),
                            set.getString(13)
                    );
                    result.put(JSONKey.USER_ID,User.fixValues(u));
                }
                set.close();
            }else {
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }finally {
            getUnit().closeConnection(connection);
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        return result.toString();
    }

    public String getSchools() {
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();
        String sql = SQL.PROCEDURE_GET_SCHOOL;
        List<School> schoolList = new ArrayList<School>();
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.registerOutParameter(1,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(1);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    School school = new School(
                            set.getString(1),
                            set.getString(2),
                            set.getInt(3),
                            set.getString(4)
                    );
                    schoolList.add(school);
                }
                set.close();
            }else {
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }finally {
            getUnit().closeConnection(connection);
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        School[] schools = schoolList.toArray(new School[schoolList.size()]);
        result.put(JSONKey.SCHOOLS,School.fixValues(schools));
        return result.toString();
    }

    public String getSubjects() {
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();
        String sql = SQL.PROCEDURE_GET_SUBJECT;
        List<Subject> subjectList = new ArrayList<Subject>();
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.registerOutParameter(1,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(1);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    Subject subject = new Subject(
                            set.getInt(1),
                            set.getString(2)
                    );
                    subjectList.add(subject);
                }
                set.close();
            }else {
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }finally {
            getUnit().closeConnection(connection);
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        Subject[] subjects = subjectList.toArray(new Subject[subjectList.size()]);
        result.put(JSONKey.SUBJECTS,Subject.fixValues(subjects));
        return result.toString();
    }

    private String cutNull(String str){
        return str != null ? str : "";
    }
}
