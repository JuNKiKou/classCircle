package muggle.dao.impl;/**
 * Created by JuN on 2017/4/17.
 */

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
}
