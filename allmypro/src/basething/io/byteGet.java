package basething.io;

import java.io.UnsupportedEncodingException;

public class byteGet {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //字符串的编码与解码
        String str1 = "中文";
        byte[] bytes = str1.getBytes("UTF-8");
        String str2 = new String(bytes, "UTF-8");
        System.out.println(str2);
    }
}
