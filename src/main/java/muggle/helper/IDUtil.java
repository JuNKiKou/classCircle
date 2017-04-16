package muggle.helper;/**
 * Created by JuN on 2017/4/16.
 */

/**
 * 生成规范的ID 工具类
 *
 * @authorJuN
 * @create2017-04-16 12:17
 */
public class IDUtil {

    public static String getNextIdTo16(String pastId,String header){
        int num = add(pastId,header);
        return format(header,num,16);
    }

    public static String getNextIdTo8(String pastId,String header){
        int num = add(pastId,header);
        return format(pastId,num,8);
    }

    public static int getNextIdInt(int pastId){
        return add(pastId);
    }



    private static int add(String pastId,String header){
        int headerLength = header.length();
        String number = pastId.substring(headerLength);
        int num = Integer.parseInt(number);
        num ++;
        return num;
    }

    private static int add(int id){
        id = id + 1;
        return id;
    }

    private static String format(String header,int number,int length){
        String numberStr = String.valueOf(number);
        int headerLength = header.length();
        int numberLength = numberStr.length();
        int restLength = length - headerLength - numberLength;
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        while (restLength > 0){
            builder.append("0");
            restLength --;
        }
        builder.append(numberStr);
        return builder.toString();
    }

}
