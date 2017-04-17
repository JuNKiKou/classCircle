package muggle.helper;/**
 * Created by JuN on 2017/4/16.
 */

import muggle.constant.Exception;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 生成规范的ID 工具类
 *
 * @authorJuN
 * @create2017-04-16 12:17
 */
public class IDUtil {

    public static String getId(Connection connection,String sql,String header,int type){
        String id = null;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.execute();
            ResultSet set = statement.getResultSet();
            while (set != null && set.next()){
                id = set.getString(1);
            }
            set.close();
            statement.close();
        } catch (SQLException e) {
            Out.print(Exception.SQL_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }

        if (type == 16){
            //16位
            id = getNextIdTo16(id,header);
        }else if (type == 8){
            //8位
            id = getNextIdTo8(id,header);
        }

        return id;

    }

    public static int getId(Connection connection,String sql){
        int id = 0;
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.execute();
            ResultSet set = statement.getResultSet();
            while (set != null && set.next()){
                id = set.getInt(1);
            }
            set.close();
            statement.close();
        } catch (SQLException e) {
            Out.print(Exception.SQL_EXECUTE_EXCEPTION);
            e.printStackTrace();
        }

        id = getNextIdInt(id);
        return id;

    }







    private static String getNextIdTo16(String pastId,String header){
        int num = add(pastId,header);
        return format(header,num,16);
    }

    private static String getNextIdTo8(String pastId,String header){
        int num = add(pastId,header);
        return format(pastId,num,8);
    }

    private static int getNextIdInt(int pastId){
        return add(pastId);
    }

    private static int add(String pastId,String header){
        int headerLength = header.length();
        String number = pastId.substring(headerLength);
        int num = Integer.parseInt(number);
        num ++;
        return num;
    }

    private static int add(int id){
        id = id + 1;
        return id;
    }

    private static String format(String header,int number,int length){
        String numberStr = String.valueOf(number);
        int headerLength = header.length();
        int numberLength = numberStr.length();
        int restLength = length - headerLength - numberLength;
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        while (restLength > 0){
            builder.append("0");
            restLength --;
        }
        builder.append(numberStr);
        return builder.toString();
    }

}
