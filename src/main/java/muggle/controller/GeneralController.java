package muggle.controller;/**
 * Created by JuN on 2017/4/17.
 */

import muggle.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @authorJuN
 * @create2017-04-17 11:18
 */
@Controller
@CrossOrigin
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    private IGeneralService service;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String login(@RequestParam(value = "telephone") String phone,@RequestParam(value = "password") String password){
        return service.login(phone,password);
    }


    @ResponseBody
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getUserInfo(@RequestParam(value = "user") String user){
        return service.getUserInfo(user);
    }


    @ResponseBody
    @RequestMapping(value = "/getSchools",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getSchools(){
        return service.getSchools();
    }

    @ResponseBody
    @RequestMapping(value = "/getSubjects",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getSubjects(){
        return service.getSubjects();
    }

    @ResponseBody
    @RequestMapping(value = "/getSms",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getSms(@RequestParam(value = "telephone") String phone){
        return service.getSms(phone);
    }
}
