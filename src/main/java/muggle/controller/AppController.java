package muggle.controller;/**
 * Created by JuN on 2017/4/20.
 */

import muggle.service.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * app端的控制器
 *
 * @authorJuN
 * @create2017-04-20 12:57
 */
@Controller
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

}
