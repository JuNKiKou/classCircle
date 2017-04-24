package muggle.helper;/**
 * Created by JuN on 2017/4/22.
 */

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import muggle.constant.JSONKey;
import muggle.constant.JSONValue;
import org.json.JSONObject;

/**
 * 短息发送工具类
 *
 * @authorJuN
 * @create2017-04-22 09:54
 */
public class SmsHelper {


    private static final String url = "http://gw.api.taobao.com/router/rest";

    //成为开发者，创建应用后系统自动生成
    private static final String appkey = "23766441";

    private static String secret = "69d51576a32a0007d0b4a11dacc7a978";

    private static final String SmsFreeSignName = "班级圈";

    public static JSONObject sendSmsMessage(String phone){
        JSONObject result = new JSONObject();
        int resultCode = JSONValue.get(JSONValue.SUCCESS);
        String number = randomCode();
        String phoneStr = "{number:'"+number+"'}";
        TaobaoClient client = new DefaultTaobaoClient(url,appkey,secret);
        AlibabaAliqinFcSmsNumSendRequest request = new AlibabaAliqinFcSmsNumSendRequest();
        request.setExtend("");
        request.setSmsType("normal");
        request.setSmsFreeSignName(SmsFreeSignName);
        request.setSmsParamString(phoneStr);
        request.setRecNum(phone);
        request.setSmsTemplateCode( "SMS_62930228" );
        try {
            AlibabaAliqinFcSmsNumSendResponse response = client.execute(request);
            result.put(JSONKey.SMS,number);
        } catch (ApiException e) {
            resultCode = JSONValue.get(JSONValue.SEND_SMS_ERROR);
            e.printStackTrace();
        }
        result.put(JSONKey.RESULT_CODE,resultCode);
        return result;
    }

    private static String randomCode(){
        int num = (int) ((Math.random()*9+1) * 100000);
        return String.valueOf(num);
    }
}
