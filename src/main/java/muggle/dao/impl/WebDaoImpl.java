package muggle.dao.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Class;
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

//    public String modifyClass(String classId, String param, int type) {
//        String[] sqls = {
//                SQL.PROCEDURE_MODIFY_SCHOOL,
//                SQL.PROCEDURE_MODIFY_CLASS_NAME,
//                SQL.PROCEDURE_MODIFY_DESCRIPTION,
//                SQL.PROCEDURE_SET_LEADER
//        };
//        boolean flag = (type == 3) ? true : false;
//
//        return modify(classId,param,sqls[type],flag);
//    }
//
//    private String modify(String classId,String param,String sql,boolean flag){
//        JSONObject result = new JSONObject();
//        Connection connection = getUnit().getConnection();
//        int resultCode = JSONValue.get(JSONValue.SUCCESS);
//        int tcId = 0;
//        if (flag){
//            //获取教师班级关系表的编号
//            String sqlStr = SQL.PROCEDURE_GET_TCID;
//            tcId = IDUtil.getId(connection,sqlStr);
//        }
//
//        try {
//            CallableStatement statement = connection.prepareCall(sql);
//            statement.setString(1,classId);
//            statement.setString(2,param);
//            if (flag){
//                statement.setInt(3,tcId);
//                statement.registerOutParameter(4,Types.INTEGER);
//            }else {
//                statement.registerOutParameter(3,Types.INTEGER);
//            }
//            statement.execute();
//            int code = statement.getInt(flag ? 4 : 3);
//            if (code != 1){
//                resultCode = JSONValue.get(JSONValue.SQL_MODIFY_CLASS_ERROR);
//            }
//        } catch (SQLException e) {
//            Out.print(Exception.SQL_EXECUTE_EXCEPTION);
//            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
//            e.printStackTrace();
//        }finally {
//            getUnit().closeConnection(connection);
//        }
//        result.put(JSONKey.RESULT_CODE,resultCode);
//        return result.toString();
//    }

}
