package muggle.controller;/**
 * Created by JuN on 2017/4/17.
 */

import muggle.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @authorJuN
 * @create2017-04-17 11:18
 */
@Controller
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    private IGeneralService service;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String login(@RequestParam(value = "telephone") String phone,@RequestParam(value = "password") String password){
        return service.login(phone,password);
    }

}
