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

    public static final String PROCEDURE_SET_LEADER = "{call setLeader(?,?,?)}";

    public static final String PROCEDURE_DELETE_CLASS = "{call deleteClass(?,?)}";

    public static final String PROCEDURE_UNBIND_LEADER = "{call unbindLeader(?,?)}";

    public static final String PROCEDURE_ADD_STUDENT = "{call addStudent(?,?,?,?)}";

    public static final String PROCEDURE_MODIFY_STUDENT_NAME = "{call modifyStudentName(?,?,?)}";

    public static final String PROCEDURE_MODIFY_STUDENT_SEX = "{call modifyStudentSex(?,?,?)}";

    public static final String PROCEDURE_MODIFY_STUDENT_CLASS = "{call modifyStudentClass(?,?,?)}";

    public static final String PROCEDURE_CUT_STUDENT = "{call cutStudent(?,?)}";

    public static final String PROCEDURE_STUDENT_BIND_CLASS = "{call studentBindClass(?,?,?)}";

    public static final String PROCEDURE_MODIFY_PASSWORD = "{call modifyPassword(?,?,?)}";

    public static final String PROCEDURE_MODIFY_USER_NAME = "{call modifyUserName(?,?,?)}";

    public static final String PROCEDURE_MODIFY_USER_SEX = "{call modifyUserSex(?,?,?)}";

    public static final String PROCEDURE_MODIFY_USER_HEADER = "{call modifyUserHeader(?,?,?)}";

    public static final String PROCEDURE_MODIFY_USER_INDEX = "{call modifyUserIndex(?,?,?)}";

    public static final String PROCEDURE_MODIFY_SUBJECT = "{call modifySubject(?,?,?)}";

    public static final String PROCEDURE_MODIFY_BIND_STUDENT = "{call modifyBindStudent(?,?,?)}";

    public static final String PROCEDURE_SEND_MESSAGE = "{call sendMessage(?,?,?,?,?)}";

    public static final String PROCEDURE_DELETE_MESSAGE = "{call deleteMessage(?,?)}";

    public static final String PROCEDURE_GIVE_Z = "{call giveZ(?,?,?)}";

    public static final String PROCEDURE_MODIFY_Z = "{call modifyZ(?,?,?)}";

    public static final String PROCEDURE_COMMENT = "{call comment(?,?,?,?)}";

    public static final String PROCEDURE_REPLY = "{call reply(?,?,?)}";

    public static final String PROCEDURE_SEARCH_CLASS = "{call searchClass(?,?)}";

    public static final String PROCEDURE_LOAD_Z = "{call loadZ(?,?,?)}";

    public static final String PROCEDURE_LOAD_COMMENT = "{call loadComment(?,?,?)}";

    public static final String PROCEDURE_LOAD_MESSAGE = "{call loadMessage(?,?,?)}";

    public static final String PROCEDURE_LOAD_DETAILS = "{call loadDetails(?,?)}";

    public static final String PROCEDURE_GET_USER_INFO = "{call getUserInfo(?,?)}";

    public static final String PROCEDURE_GET_CLASS_INFO = "{call getClassInfo(?,?)}";

    public static final String PROCEDURE_GET_CLASS_STUDENTS = "{call getClassStudents(?,?)}";

    public static final String PROCEDURE_GET_CLASS_TEACHERS = "{call getClassTeachers(?,?)}";

    public static final String PROCEDURE_GET_SCHOOL = "{call getSchool(?)}";

    public static final String PROCEDURE_GET_SUBJECT = "{call getSubject(?)}";

    public static final String PROCEDURE_GET_CONTACTS = "{call getContacts(?,?)}";

    public static final String PROCEDURE_ADD_NOTICE = "{call addNotice(?,?,?,?)}";

    public static final String PROCEDURE_DELETE_NOTICE = "{call deleteNotice(?,?)}";

    public static final String PROCEDURE_GET_NOTICES = "{call getNotices(?,?)}";

    public static final String PROCEDURE_ADD_NOTICE_SIGN = "{call addNoticeSign(?,?,?)}";

    public static final String PROCEDURE_ADD_TALK = "{call addTalk(?,?,?,?,?)}";

    public static final String PROCEDURE_DELETE_TALK = "{call deleteTalk(?,?)}";

    public static final String PROCEDURE_LOAD_TALKS = "{call loadTalks(?,?,?,?)}";

    public static final String PROCEDURE_LOAD_MESSAGE_COUNT = "{call loadMessageCount(?,?,?)}";

    public static final String PROCEDURE_LOAD_NOTICE_COUNT = "{call loadNoticeCount(?,?,?)}";

}
