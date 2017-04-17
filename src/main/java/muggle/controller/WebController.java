package muggle.controller;/**
 * Created by JuN on 2017/4/17.
 */

import muggle.service.IWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * web端功能的控制器
 *
 * @authorJuN
 * @create2017-04-17 19:42
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private IWebService service;

    @ResponseBody
    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
    public String register(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "sex") boolean sex,
            @RequestParam(value = "subject") int subject,
            @RequestParam(value = "telephone") String phone,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "leader") boolean leader)
    {
        return service.registerTeacher(name,sex,subject,phone,password,leader);
    }

}
