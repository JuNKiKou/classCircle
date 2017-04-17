package muggle.dao.impl;/**
 * Created by JuN on 2017/4/17.
 */

import muggle.dao.unit.DBUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 基本的类
 *
 * @authorJuN
 * @create2017-04-17 16:14
 */
@Repository
public class BaseDaoImpl {

    @Autowired
    private DBUnit unit;

    public DBUnit getUnit(){
        return unit;
    }

}
