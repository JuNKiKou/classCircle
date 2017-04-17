package muggle.service.impl;/**
 * Created by JuN on 2017/4/17.
 */

import entity.params.Parent;
import entity.params.Teacher;
import muggle.dao.IGeneralDao;
import muggle.service.IGeneralService;
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
}
