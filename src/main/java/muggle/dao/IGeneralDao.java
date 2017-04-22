package muggle.dao;

/**
 * Created by JuN on 2017/4/16.
 */
public interface IGeneralDao {

    public abstract String login(String phone,String password);

    public abstract String getUserInfo(String user);

    public abstract String getSchools();

    public abstract String getSubjects();

}
