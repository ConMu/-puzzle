package basething.lambda.lamcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * removeIf()
 *
 * @author mucongcong
 * @date 2022/05/11 15:12
 * @since
 **/
public class LambdaDemo3 {
    public static void main(String[] args) {
        // 使用迭代器删除列表元素
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            if (it.next().length() > 3) { // 删除长度大于3的元素
                it.remove();
            }
        }
        // 使用removeIf()结合Lambda表达式实现
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list1.removeIf(s -> s.length() > 3);
    }
}
