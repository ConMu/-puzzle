package basething.lambda.lamcollection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author mucongcong
 * @date 2022/05/10 10:55
 * @since
 **/
public class LambdaDemo2 {
    public static void main(String[] args) {
        //增强for循环
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        for(String str : list){
            if(str.length()>3) {
                System.out.println(str);
            }
        }
    }
}
