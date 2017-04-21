package muggle.dao.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Class;
import entity.params.Parent;
import entity.params.Teacher;
import muggle.constant.*;
import muggle.constant.Exception;
import muggle.dao.IWebDao;
import muggle.helper.Out;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

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

        //注册教师
        String sql = SQL.PROCEDURE_REGISTER_TEACHER;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,teacher.getName());
            statement.setBoolean(2,teacher.getSex());
            statement.setInt(3,teacher.getSubject());
            statement.setString(4,teacher.getPhone());
            statement.setString(5,teacher.getPassword());
            statement.setBoolean(6,teacher.getIs_leader());
            statement.registerOutParameter(7, Types.INTEGER);
            statement.execute();
            int code = statement.getInt(7);
            if (code == -1){
                resultCode = JSONValue.get(JSONValue.SQL_REGISTER_USER_EXISTS);
            }else if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    result.put(JSONKey.USER_ID,set.getString(1));
                }
                set.close();
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
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        int code = 0;
        String userId = null;
        //注册家长
        String sql = SQL.PROCEDURE_REGISTER_PARENT;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,parent.getName());
            statement.setBoolean(2,parent.getSex());
            statement.setString(3,parent.getPhone());
            statement.setString(4,parent.getPassword());
            statement.registerOutParameter(5,Types.INTEGER);
            statement.execute();
            code = statement.getInt(5);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    userId = set.getString(1);
                }
                set.close();
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            Out.print(Exception.SQL_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }

        //绑定学生
        if (code == 1){
            sql = SQL.PROCEDURE_PARENT_BIND_STUDENT;
            try {
                CallableStatement statement = connection.prepareCall(sql);
                statement.setString(1,userId);
                statement.setString(2,studentId);
                statement.registerOutParameter(3,Types.INTEGER);
                statement.execute();
                code = statement.getInt(3);
                statement.close();
            } catch (SQLException e) {
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
                Out.print(Exception.SQL_EXECUTE_EXCEPTION);
                e.printStackTrace();
            }
        }else if (code == -1){
            resultCode = JSONValue.get(JSONValue.SQL_REGISTER_USER_EXISTS);
        }else {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
        }

        if (code == 1){
            result.put(JSONKey.USER_ID,userId);
        }

        result.put(JSONKey.RESULT_CODE,resultCode);
        getUnit().closeConnection(connection);


        return result.toString();
    }

    public String addClass(Class c, String leader) {
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();

        //添加班级
        String sql = SQL.PROCEDURE_ADD_CLASS;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,c.getName());
            statement.setString(2,c.getSchool());
            statement.setString(3,c.getDescription());
            statement.setString(4,leader);
            statement.registerOutParameter(5,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(5);

            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    result.put(JSONKey.CLASS_ID,set.getString(1));
                }
                set.close();
            }else if (code == -1){
                resultCode = JSONValue.get(JSONValue.SQL_ADD_CLASS_EXISTS);
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

    public String modifyClass(String classId, String param, int type) {
        String[] sqls = {
                SQL.PROCEDURE_MODIFY_SCHOOL,
                SQL.PROCEDURE_MODIFY_CLASS_NAME,
                SQL.PROCEDURE_MODIFY_DESCRIPTION,
                SQL.PROCEDURE_SET_LEADER
        };

        return modify(classId,param,sqls[type]);
    }

    public String deleteClass(String classId) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_DELETE_CLASS;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,classId);
            statement.registerOutParameter(2,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(2);
            if (code != 1){
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

    public String unbindLeader(String classId) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_UNBIND_LEADER;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,classId);
            statement.registerOutParameter(2,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(2);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.SQL_UNBIND_LEADER_EXCEPTION);
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

    public String addStudent(String name, boolean sex, String classId) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_ADD_STUDENT;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,name);
            statement.setBoolean(2,sex);
            statement.setString(3,classId);
            statement.registerOutParameter(4,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(4);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    result.put(JSONKey.STUDENT_ID,set.getString(1));
                }
                set.close();
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

    public String modifyStudent(String studentId, String param, int type) {
        String[] sqls = {
            SQL.PROCEDURE_MODIFY_STUDENT_NAME,
            SQL.PROCEDURE_MODIFY_STUDENT_SEX,
            SQL.PROCEDURE_MODIFY_STUDENT_CLASS
        };
        int flag = (type == 1) ? 1 : 0;
        return modify(studentId,param,sqls[type],flag);
    }

    public String cutStudent(String studentId) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_CUT_STUDENT;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,studentId);
            statement.registerOutParameter(2,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(2);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.SQL_CUT_STUDENT_ERROR);
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

    public String studentBindClass(String studentId, String classId) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_STUDENT_BIND_CLASS;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,studentId);
            statement.setString(2,classId);
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        } finally {
            getUnit().closeConnection(connection);
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        return result.toString();
    }

    public String modifyUser(String userId, String param, int type) {
        String[] sqls = {
            SQL.PROCEDURE_MODIFY_USER_NAME,
            SQL.PROCEDURE_MODIFY_USER_SEX,
            SQL.PROCEDURE_MODIFY_USER_HEADER,
            SQL.PROCEDURE_MODIFY_USER_INDEX,
            SQL.PROCEDURE_MODIFY_PASSWORD,
            SQL.PROCEDURE_MODIFY_SUBJECT,
            SQL.PROCEDURE_MODIFY_BIND_STUDENT
        };
        int flag;
        switch (type){
            case 1:
                flag = 1;
                break;
            case 5:
                flag = 2;
                break;
            default:
                flag = 0;
                break;
        }
        return modify(userId,param,sqls[type],flag);
    }

    public String searchClass(String keyword) {
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_SEARCH_CLASS;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,keyword);
            statement.registerOutParameter(2,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(2);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    JSONObject item = new JSONObject();
                    item.put(JSONKey.CLASS_ID,set.getString(1));
                    item.put(JSONKey.CLASS_NAME,set.getString(2));
                    item.put(JSONKey.CLASS_DESCRIPTION,set.getString(3));
                    array.put(item);
                }
                set.close();
            }else {
                resultCode = JSONValue.get(JSONValue.SEARCH_CLASS_ERROR);
            }

            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        } finally {
            getUnit().closeConnection(connection);
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        result.put(JSONKey.CLASSES,array);
        return result.toString();
    }

    private String modify(String classId, String param, String sql){
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);

        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,classId);
            statement.setString(2,param);
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.SQL_MODIFY_CLASS_ERROR);
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

    private String modify(String id,String param,String sql,int flag){
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,id);
            if (flag == 1){
                statement.setBoolean(2,Boolean.parseBoolean(param));
            }else if (flag == 0){
                statement.setString(2,param);
            }else if (flag == 2){
                statement.setInt(2,Integer.parseInt(param));
            }
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code != 1){
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


}
