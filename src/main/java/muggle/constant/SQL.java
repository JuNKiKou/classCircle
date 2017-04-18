package muggle.constant;/**
 * Created by JuN on 2017/4/16.
 */

import javax.print.DocFlavor;

/**
 * 调用的SQL语句
 *
 * @authorJuN
 * @create2017-04-16 12:46
 */
public class SQL {


    public static final String PROCEDURE_LOGIN = "{call login(?,?,?)}";

    public static final String PROCEDURE_REGISTER_TEACHER = "{call registerTeacher(?,?,?,?,?,?,?)}";

    public static final String PROCEDURE_REGISTER_PARENT = "{call registerParent(?,?,?,?,?)}";

    public static final String PROCEDURE_PARENT_BIND_STUDENT = "{call parentBindStudent(?,?,?)}";

    public static final String PROCEDURE_ADD_CLASS = "{call addClass(?,?,?,?,?)}";

    public static final String PROCEDURE_MODIFY_CLASS_NAME = "{call modifyClassName(?,?,?)}";

    public static final String PROCEDURE_MODIFY_SCHOOL = "{call modifySchool(?,?,?)}";

    public static final String PROCEDURE_MODIFY_DESCRIPTION = "{call modifyDescription(?,?,?)}";

    public static final String PROCEDURE_SET_LEADER = "{call setLeader(?,?,?,?)}";

}
