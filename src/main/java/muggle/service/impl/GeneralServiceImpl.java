package muggle.service.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Parent;
import entity.params.Teacher;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import muggle.dao.IGeneralDao;
import muggle.helper.SmsHelper;
import muggle.service.IGeneralService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * @authorJuN
 * @create2017-04-17 11:16
 */
@Service
public class GeneralServiceImpl implements IGeneralService{

    @Autowired
    private IGeneralDao dao;

    public String login(String phone, String password) {
        return dao.login(phone,password);
    }

    public String getUserInfo(String user) {
        return dao.getUserInfo(user);
    }

    public String getSchools() {
        return dao.getSchools();
    }

    public String getSubjects() {
        return dao.getSubjects();
    }

    public String getSms(String phone) {
        JSONObject object = SmsHelper.sendSmsMessage(phone);
        return object.toString();
    }
}
