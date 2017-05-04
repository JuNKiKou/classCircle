package muggle.controller;/**
 * Created by JuN on 2017/4/17.
 */

import muggle.service.IWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * web端功能的控制器
 *
 * @authorJuN
 * @create2017-04-17 19:42
 */
@Controller
@CrossOrigin
@RequestMapping("/web")
public class WebController {

    @Autowired
    private IWebService service;

    @ResponseBody
    @RequestMapping(value = "/registerTeacher",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
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

    @ResponseBody
    @RequestMapping(value = "/registerParent",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
    public String register(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "sex") boolean sex,
            @RequestParam(value = "telephone") String phone,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "student") String studentId)
    {
        return service.registerParent(name,sex,phone,password,studentId);
    }

    @ResponseBody
    @RequestMapping(value = "/addClass",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
    public String addClass(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "school") String school,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "leader") String leader)
    {
        return service.addClass(name,school,description,leader);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyClass",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String modifyClass(
            @RequestParam(value = "class") String classId,
            @RequestParam(value = "param") String param,
            @RequestParam(value = "type") int type)
    {
        return service.modifyClass(classId,param,type);
    }


    @ResponseBody
    @RequestMapping(value = "/deleteClass",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String deleteClass(
            @RequestParam(value = "class") String classId)
    {
        return service.deleteClass(classId);
    }


    @ResponseBody
    @RequestMapping(value = "/unbindLeader",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String unbindLeader(@RequestParam(value = "class") String classId){
        return service.unbindLeader(classId);
    }

    @ResponseBody
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String addStudent(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "sex") boolean sex,
            @RequestParam(value = "class") String classId)
    {
        return service.addStudent(name,sex,classId);
    }



    @ResponseBody
    @RequestMapping(value = "/modifyStudent",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String modifyStudent(
            @RequestParam(value = "student") String studentId,
            @RequestParam(value = "param") String param,
            @RequestParam(value = "type") int type)
    {
       return service.modifyStudent(studentId,param,type);
    }


    @ResponseBody
    @RequestMapping(value = "/cutStudent",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String cutStudent(@RequestParam(value = "student") String studentId){
        return service.cutStudent(studentId);
    }

    @ResponseBody
    @RequestMapping(value = "/studentBindClass",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String studentBindClass(
            @RequestParam(value = "student") String studentId,
            @RequestParam(value = "class") String classId)
    {
        return service.studentBindClass(studentId,classId);
    }


    @ResponseBody
    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String modifyUser(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "type") int type,
            @RequestParam(value = "param") String param)
    {
       return service.modifyUserInfo(user,param,type);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyUserPhoto",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String modifyUser(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "type") int type,
            @RequestParam(value = "file") MultipartFile file)
    {
        return service.modifyUserInfo(user,type,file);
    }

    @ResponseBody
    @RequestMapping(value = "/searchClass",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String search(@RequestParam(value = "keyword") String keyword){
        return service.searchClass(keyword);
    }




    @ResponseBody
    @RequestMapping(value = "/getClassInfo",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getClassInfo(@RequestParam(value = "class") String classId){
        return service.getClassInfo(classId);
    }

}
