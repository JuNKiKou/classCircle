package muggle.controller;/**
 * Created by JuN on 2017/4/20.
 */

import entity.params.Notice;
import muggle.service.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * app端的控制器
 *
 * @authorJuN
 * @create2017-04-20 12:57
 */
@Controller
@CrossOrigin
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IAppService service;

    @ResponseBody
    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String sendMessage(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "content",required = false) String content,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "audio",required = false) MultipartFile audio,
            @RequestParam(value = "radio",required = false) MultipartFile radio,
            @RequestParam(value = "pictures",required = false) MultipartFile[] pictures)
    {
        return service.sendMessage(user,content,type,pictures,radio,audio);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMessage",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String deleteMessage(@RequestParam(value = "message") String message)
    {
        return service.deleteMessage(message);
    }

    @ResponseBody
    @RequestMapping(value = "/give",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String give(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "message") String message)
    {
        return service.giveZ(user,message);
    }


    @ResponseBody
    @RequestMapping(value = "/modifyZ",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String modifyZ(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "message") String message)
    {
        return service.modifyZ(user,message);
    }


    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String comment(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "message") String message,
            @RequestParam(value = "content") String content)
    {
        return service.comment(user,message,content);
    }


    @ResponseBody
    @RequestMapping(value = "/reply",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String reply(
            @RequestParam(value = "comment") String comment,
            @RequestParam(value = "content") String content)
    {
        return service.reply(comment,content);
    }

    @ResponseBody
    @RequestMapping(value = "/loadMessages",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String loadMessages(
            @RequestParam(value = "class") String classId,
            @RequestParam(value = "counts") int counts)
    {
        return service.loadMessages(classId,counts);
    }

    @ResponseBody
    @RequestMapping(value = "/loadMessage",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String loadMessage(@RequestParam(value = "message") String message){
        return service.loadMessage(message);
    }


    @ResponseBody
    @RequestMapping(value = "/loadContacts",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String loadContacts(@RequestParam(value = "class") String classId){
        return service.loadContacts(classId);
    }

    @ResponseBody
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String addNotice(
            @RequestParam(value = "user") String user,
            @RequestParam(value = "class") String classId,
            @RequestParam(value = "content") String content)
    {
        return service.addNotice(user,classId,content);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteNotice",method = RequestMethod.POST,produces = "text/html")
    public String deleteNotice(@RequestParam(value = "notice") String notice){
        return service.deleteNotice(notice);
    }


    @ResponseBody
    @RequestMapping(value = "/getNotices",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getNotices(@RequestParam(value = "class") String classId){
        return service.getNotices(classId);
    }


    @ResponseBody
    @RequestMapping(value = "/addNoticeSign",method = RequestMethod.POST,produces = "text/html")
    public String addNoticeSign(
            @RequestParam(value = "notice") String notice,
            @RequestParam(value = "user") String user)
    {
        return service.addNoticeSign(notice,user);
    }

    @ResponseBody
    @RequestMapping(value = "/addTalk",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String addTalk(
            @RequestParam(value = "from") String from,
            @RequestParam(value = "to") String to,
            @RequestParam(value = "file",required = false) MultipartFile file,
            @RequestParam(value = "type") int type,
            @RequestParam(value = "content",required = false) String content)
    {
        return service.addTalk(from,to,file,type,content);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTalk",method = RequestMethod.POST,produces = "text/html")
    public String deleteTalk(@RequestParam(value = "talk") String talk){
        return service.deleteTalk(talk);
    }


    @ResponseBody
    @RequestMapping(value = "/loadTalks",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String loadTalks(
            @RequestParam(value = "user1") String user1,
            @RequestParam(value = "user2") String user2,
            @RequestParam(value = "count") int count
    ){
        return service.loadTalks(user1,user2,count);
    }

    @ResponseBody
    @RequestMapping(value = "/loadMessageCount",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String loadMessageCount(
            @RequestParam(value = "class") String classId,
            @RequestParam(value = "time") long time)
    {
        return service.loadMessageCount(classId,time);
    }


    @ResponseBody
    @RequestMapping(value = "/loadNoticeCount",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String loadNoticeCount(
            @RequestParam(value = "class") String classId,
            @RequestParam(value = "time") long time)
    {
        return service.loadNoticeCount(classId,time);
    }

}
