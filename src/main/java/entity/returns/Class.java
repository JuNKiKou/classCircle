package entity.returns;/**
 * Created by JuN on 2017/4/21.
 */

import org.json.JSONObject;

/**
 * 班级实体类
 *
 * @authorJuN
 * @create2017-04-21 19:59
 */
public class Class {

    private static final String ID = "id";

    private String id;

    private static final String NAME = "name";

    private String name;

    private static final String DESCRIPTION = "description";

    private String description;

    private static final String SCHOOLNAME = "schoolName";

    private String schoolName;

    private static final String SCHOOLAREA = "schoolArea";

    private String schoolArea;

    private static final String TEACHERS = "teachers";

    private T[] ts;

    private static final String STUDENTS = "students";

    private Student[] students;

    public T[] getTs() {
        return ts;
    }

    public void setTs(T[] ts) {
        this.ts = ts;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolArea() {
        return schoolArea;
    }

    public Class(String id, String name, String description, String schoolName, String schoolArea) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.schoolName = schoolName;
        this.schoolArea = schoolArea;
    }

    public static JSONObject fixValues(Class c){
        JSONObject object = new JSONObject();
        object.put(ID,c.getId());
        object.put(NAME,c.getName());
        object.put(DESCRIPTION,c.getDescription());
        object.put(SCHOOLNAME,c.getSchoolName());
        object.put(SCHOOLAREA,c.getSchoolArea());
        object.put(TEACHERS,T.fixValues(c.getTs()));
        object.put(STUDENTS,Student.fixValues(c.getStudents()));
        return object;
    }
}
