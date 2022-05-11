package basething.lambda.lamcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * sort()
 *该方法定义在List接口中，方法签名为void sort(Comparator<? super E> c)，该方法根据c指定的比较规则对容器元素进行排序。
 *
 * @author mucongcong
 * @date 2022/05/11 15:12
 * @since
 **/
public class LambdaDemo5 {
    public static void main(String[] args) {
        // Collections.sort()方法
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                return str1.length()-str2.length();
            }
        });

        //可以直接使用List.sort()方法，结合Lambda表达式
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list2.sort((str1, str2) -> str1.length() - str2.length());
    }
}
