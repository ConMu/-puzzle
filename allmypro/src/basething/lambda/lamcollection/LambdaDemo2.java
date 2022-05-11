package basething.lambda.lamcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

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

        // 现在使用forEach()方法结合匿名内部类，可以这样实现
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list2.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if(s.length()>3) {
                    System.out.println(s);
                }
            }
        });
        // 使用forEach()结合Lambda表达式迭代
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list3.forEach(s -> {
            if (s.length() > 3) {
                System.out.println(s);
            }
        });
    }
}
