package muggle.dao.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.returns.Comment;
import entity.returns.Message;
import entity.returns.Reply;
import entity.returns.Z;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import muggle.constant.SQL;
import muggle.dao.IAppDao;
import muggle.helper.PathHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @authorJuN
 * @create2017-04-17 16:13
 */
@Repository
public class AppDaoImpl extends BaseDaoImpl implements IAppDao{

    public String sendMessage(String user, String content, String path, String type) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_SEND_MESSAGE;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,user);
            statement.setString(2,type);
            statement.setString(3,content);
            statement.setString(4,path);
            statement.registerOutParameter(5, Types.INTEGER);
            statement.execute();
            int code = statement.getInt(5);
            if (code == -1){
                resultCode = JSONValue.get(JSONValue.SEND_MESSAGE_ERROR);
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

    public String deleteMessage(String message) {
        Connection connection = getUnit().getConnection();
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_DELETE_MESSAGE;
        String path = null;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,message);
            statement.registerOutParameter(2,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(2);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    path = set.getString(1);
                }
                set.close();
            }else {
                resultCode = JSONValue.get(JSONValue.DELETE_MESSAGE_ERROR);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }finally {
            getUnit().closeConnection(connection);
        }

        //删除文件
        String str = PathHelper.releasePath(path);
        if (!str.equals("") && str != null){
            JSONObject object = new JSONObject(str);
            if (object.has(JSONKey.AUDIO_PATH)){
                String p = object.getString(JSONKey.AUDIO_PATH);
                File file = new File(p);
                file.delete();
            }
            if (object.has(JSONKey.RADIO_PATH)){
                String p = object.getString(JSONKey.RADIO_PATH);
                File file = new File(p);
                file.delete();
            }
            if (object.has(JSONKey.PHOTO_PATH)){
                JSONArray ps = object.getJSONArray(JSONKey.PHOTO_PATH);
                for (int i = 0; i < ps.length(); i++) {
                    String p = ps.getString(i);
                    File file = new File(p);
                    file.delete();
                }
            }
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        return result.toString();
    }

    public String giveZ(String user, String message) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_GIVE_Z;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,user);
            statement.setString(2,message);
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.GIVE_Z_ERROR);
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

    public String modifyZ(String user, String message) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_MODIFY_Z;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,user);
            statement.setString(2,message);
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.MODIFY_Z_ERROR);
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

    public String comment(String user, String message, String content) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_COMMENT;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,user);
            statement.setString(2,message);
            statement.setString(3,content);
            statement.registerOutParameter(4,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(4);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.COMMENT_ERROR);
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

    public String reply(String comment, String content) {
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        Connection connection = getUnit().getConnection();
        String sql = SQL.PROCEDURE_REPLY;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,comment);
            statement.setString(2,content);
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code != 1){
                resultCode = JSONValue.get(JSONValue.REPLY_ERROR);
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

    public String loadMessages(String classId,int counts) {
        JSONObject result = new JSONObject();
        Connection connection = getUnit().getConnection();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String sql = SQL.PROCEDURE_LOAD_MESSAGE;
        List<Message> messages = new ArrayList<Message>();
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1,classId);
            statement.setInt(2,counts);
            statement.registerOutParameter(3,Types.INTEGER);
            statement.execute();
            int code = statement.getInt(3);
            if (code == 1){
                ResultSet set = statement.getResultSet();
                while (set != null && set.next()){
                    Message message = new Message(
                            set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5),
                            set.getString(6),
                            set.getInt(7),
                            set.getString(8),
                            set.getString(9),
                            set.getString(10),
                            set.getBoolean(11),
                            set.getString(12)
                    );
                    messages.add(message);
                }
                set.close();

            }else {
                resultCode = JSONValue.get(JSONValue.LOAD_MESSAGE_ERROR);
            }
            statement.close();
        } catch (SQLException e) {
            resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }


        //获取评论和回复
        sql = SQL.PROCEDURE_LOAD_COMMENT;
        for (Message message : messages){
            List<Comment> cs = new ArrayList<Comment>();
            try {
                CallableStatement statement = connection.prepareCall(sql);
                statement.setString(1,message.getId());
                statement.setBoolean(2,false);
                statement.registerOutParameter(3,Types.INTEGER);
                statement.execute();
                int code = statement.getInt(3);
                if (code == 2){
                    message.setComment_more(true);
                }
                if (code == 1 || code == 2){
                    ResultSet set = statement.getResultSet();
                    while (set != null && set.next()){
                        Reply reply = new Reply(
                                set.getString(8),
                                set.getString(9),
                                set.getString(10)
                        );
                        Comment comment = new Comment(
                                set.getString(1),
                                set.getString(2),
                                set.getString(3),
                                set.getString(4),
                                set.getInt(5),
                                set.getString(6),
                                set.getString(7),
                                reply,
                                set.getString(11),
                                set.getBoolean(12),
                                set.getString(13)
                        );
                        cs.add(comment);
                    }
                    set.close();
                }else {
                    resultCode = JSONValue.get(JSONValue.LOAD_MESSAGE_ERROR);
                }
                statement.close();
            } catch (SQLException e) {
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
                e.printStackTrace();
            }
            Comment[] comments = cs.toArray(new Comment[cs.size()]);
            message.setComments(comments);
        }


        //获取赞
        sql = SQL.PROCEDURE_LOAD_Z;
        for (Message message : messages){
            List<Z> zList = new ArrayList<Z>();
            try {
                CallableStatement statement = connection.prepareCall(sql);
                statement.setString(1,message.getId());
                statement.setBoolean(2,false);
                statement.registerOutParameter(3,Types.INTEGER);
                statement.execute();
                int code = statement.getInt(3);
                if (code == 2){
                    message.setZ_more(true);
                }
                if (code == 1 || code == 2){
                    ResultSet set = statement.getResultSet();
                    while (set != null && set.next()){
                        Z z = new Z(
                                set.getInt(2),
                                set.getString(1),
                                set.getString(3),
                                set.getInt(4),
                                set.getString(5),
                                set.getBoolean(6),
                                set.getString(7)
                        );
                        zList.add(z);
                    }
                    set.close();
                }else {
                    resultCode = JSONValue.get(JSONValue.LOAD_MESSAGE_ERROR);
                }
                statement.close();
            } catch (SQLException e) {
                resultCode = JSONValue.get(JSONValue.SQL_PROCEDURE_EXECUTE_EXCEPTION);
                e.printStackTrace();
            }
            Z[] zs = zList.toArray(new Z[zList.size()]);
            message.setZs(zs);
        }

        getUnit().closeConnection(connection);
        Message[] array = messages.toArray(new Message[messages.size()]);
        result.put(JSONKey.RESULT_CODE,resultCode);
        result.put(JSONKey.MESSAGES,Message.fixValues(array));


        return result.toString();
    }

    public String loadMessage(String message) {
        return null;
    }
}

