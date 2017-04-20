package muggle.helper;/**
 * Created by JuN on 2017/4/20.
 */

import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传下载文件相关
 *
 * @authorJuN
 * @create2017-04-20 08:49
 */
public class LoadHelper {

    public static String uploadFile(MultipartFile file,String rootDir){
        checkRoot(rootDir);
        JSONObject result = new JSONObject();
        //包装名称
        String origin = file.getOriginalFilename();
        int index = origin.lastIndexOf("/");
        origin = origin.substring(index + 1);
        //获取后缀
        String suffix = origin.substring(origin.lastIndexOf("."));
        String now = FormatTime.getCurrentTime();
        String uuid = UUID.randomUUID().toString();
        String name = rootDir + uuid + now + suffix;
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        if (!file.isEmpty()){
            try {
                file.transferTo(new File(name));
                result.put(JSONKey.FILE_PATH,name);
            } catch (IOException e) {
                resultCode = JSONValue.get(JSONValue.FILE_UPLOAD_ERROR);
                e.printStackTrace();
            }
        }else {
            resultCode = JSONValue.get(JSONValue.FILE_UPLOAD_ERROR);
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        return result.toString();
    }

    private static void checkRoot(String rootDir){
        File dir = new File(rootDir);
        if (!dir.exists() || !dir.isDirectory()){
            dir.mkdir();
        }
    }

}
