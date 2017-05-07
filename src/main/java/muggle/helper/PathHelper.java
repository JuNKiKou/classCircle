package muggle.helper;/**
 * Created by JuN on 2017/4/20.
 */

import muggle.constant.JSONKey;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.print.DocFlavor;

/**
 * 合成和解码路径
 *
 * @authorJuN
 * @create2017-04-20 12:23
 */
public class PathHelper {

    public static final String SPACE_TYPE = "||";

    private static final String SPACE_TYPE_TRAN = "\\|\\|";

    private static final String RADIO_HEADER = "radio : ";

    private static final String AUDIO_HEADER = "audio : ";

    private static final String PICTURES_HEADER = "pictures : ";

    private static final String SPACE_ITEM = "|";

    private static final String SPACE_ITEM_TRAN = "\\|";

    public static String addPictures(String[] paths){
        StringBuilder builder = new StringBuilder();
        builder.append(PICTURES_HEADER);
        for (int i = 0; i < paths.length; i++) {
            builder.append(paths[i]);
            if (i < paths.length -1){
                builder.append(SPACE_ITEM);
            }
        }
        return builder.toString();
    }

    public static String addAudio(String str){
        return AUDIO_HEADER + str;
    }

    public static String addRadio(String str){
        return RADIO_HEADER + str;
    }

    public static String releasePath(String path){
        String[] paths = path.split(SPACE_TYPE_TRAN);
        JSONObject result = new JSONObject();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].contains(AUDIO_HEADER)){
                String rs = cutHeader(paths[i],AUDIO_HEADER);
                result.put(JSONKey.AUDIO_PATH,rs);
            }
            if (paths[i].contains(RADIO_HEADER)){
                String rs = cutHeader(paths[i],RADIO_HEADER);
                result.put(JSONKey.RADIO_PATH,rs);
            }
            if (paths[i].contains(PICTURES_HEADER)){
                String rs = cutHeader(paths[i],PICTURES_HEADER);
                //分开路径

                String[] its = rs.split(SPACE_ITEM_TRAN);
                JSONArray array = new JSONArray();
                for (int j = 0; j < its.length; j++) {
                    array.put(its[j]);
                }
                result.put(JSONKey.PHOTO_PATH,array);
            }
        }
        return result.toString();

    }

    //去头
    private static String cutHeader(String str,String header){
        int length = header.length();
        return str.substring(length);
    }
}
