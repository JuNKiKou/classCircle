package muggle.constant;/**
 * Created by JuN on 2017/4/9.
 */

/**
 * 路径常量
 *
 * @authorJuN
 * @create2017-04-09 16:39
 */
public class Path {

    public static final String SQL_PROPERTIES_FILE_PATH = "classCircle.properties";

    public static String USER_HEADER_SAVE_DIR;

    public static String USER_INDEX_SAVE_DIR;

    static {
        USER_HEADER_SAVE_DIR = System.getProperty("root") + "/header/";
        USER_INDEX_SAVE_DIR = System.getProperty("root") + "/index/";
    }
}
