package basething.lambda.lamcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * spliterator()
 *方法签名为Spliterator<E> spliterator()，该方法返回容器的可拆分迭代器
 * stream()和parallelStream()
 * stream()和parallelStream()分别返回该容器的Stream视图表示，不同之处在于parallelStream()返回并行的Stream。Stream是Java函数式编程的核心类，我们会在后面章节中学习。
 *
 * @author mucongcong
 * @date 2022/05/11 15:12
 * @since
 **/
public class LambdaDemo6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
    }
}
