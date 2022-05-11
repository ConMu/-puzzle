package basething.lambda.lamcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.UnaryOperator;

/**
 * replaceAll()
 *该方法签名为void replaceAll(UnaryOperator<E> operator)，作用是对每个元素执行operator指定的操作，并用操作结果来替换原来的元素。其中UnaryOperator是一个函数接口，里面只有一个待实现函数T apply(T t)。
 *
 * @author mucongcong
 * @date 2022/05/11 15:12
 * @since
 **/
public class LambdaDemo4 {
    public static void main(String[] args) {
        // 使用匿名内部类实现
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.replaceAll(new UnaryOperator<String>(){
            @Override
            public String apply(String str){
                if (str.length() > 3) {
                    return str.toUpperCase();
                }
                return str;
            }
        });

        //使用Lambda表达式实现
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list2.replaceAll(s -> {
            if (s.length() > 3) {
                return s.toUpperCase();
            }
            return s;
        });
    }
}
