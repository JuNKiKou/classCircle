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

    public static final String PROCEDURE_GET_CLASSID = "{call getClassId()}";

    public static final String PROCEDURE_GET_COMMENTID = "{call getCommentId()}";

    public static final String PROCEDURE_GET_MESSAGEID = "{call getMessageId()}";

    public static final String PROCEDURE_GET_PARENTID = "{call getParentId()}";

    public static final String PROCEDURE_GET_PSID = "{call getPSId()}";

    public static final String PROCEDURE_GET_REPLYID = "{call getReplyId()}";

    public static final String PROCEDURE_GET_SCHOOLID = "{call getSchoolId()}";

    public static final String PROCEDURE_GET_STUDENTID = "{call getStudentId()}";

    public static final String PROCEDURE_GET_TCID = "{call getTCId()}";

    public static final String PROCEDURE_GET_TEACHERID = "{call getTeacherId()}";

    public static final String PROCEDURE_GET_USERID = "{call getUserId()}";

    public static final String PROCEDURE_GET_ZID = "{call getZId()}";

    public static final String PROCEDURE_LOGIN = "{call login(?,?,?)}";

}
