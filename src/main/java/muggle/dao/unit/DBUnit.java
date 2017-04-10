package muggle.dao.unit;/**
 * Created by JuN on 2017/4/9.
 */

import muggle.constant.Exception;
import muggle.constant.Path;
import muggle.helper.Out;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接的单例对象
 *
 * @authorJuN
 * @create2017-04-09 16:18
 */
@Repository
public class DBUnit {


    public Connection getConnection(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(Path.SQL_PROPERTIES_FILE_PATH);
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            Out.print(Exception.SQL_LOAD_PROPERTIES_FILE_FAILED);
            e.printStackTrace();
        }

        String driver = properties.getProperty(muggle.constant.Properties.JDBC_DRIVER);
        String url = properties.getProperty(muggle.constant.Properties.JDBC_URL);
        String username = properties.getProperty(muggle.constant.Properties.JDBC_USERNAME);
        String password = properties.getProperty(muggle.constant.Properties.JDBC_PASSWORD);

        return openConnection(driver,url,username,password);
    }

    public void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                Out.print(Exception.SQL_CLOSE_CONNECTION_FAILED);
                e.printStackTrace();
            }
        }
    }

    private Connection openConnection(String driver,String url,String username,String password){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            Out.print(Exception.SQL_DRIVER_CAN_NOT_FOUND);
            e.printStackTrace();
        } catch (SQLException e) {
            Out.print(Exception.SQL_OPEN_CONNECTION_FAILED);
            e.printStackTrace();
        }
        return connection;

    }

}
