package basething.lambda.lamstream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect()
 * Java 8允许在接口中加入具体方法。接口中的具体方法有两种，default方法和static方法，identity()就是Function接口的一个静态方法。
 * Function.identity()返回一个输出跟输入一样的Lambda表达式对象，等价于形如t -> t形式的Lambda表达式。
 * collect()方法定义为<R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)，
 * 三个参数依次对应上述三条分析。不过每次调用collect()都要传入这三个参数太麻烦，
 * 收集器Collector就是对这三个参数的简单封装,所以collect()的另一定义为<R,A> R collect(Collector<? super T,A,R> collector)
 * 收集器（Collector）是为Stream.collect()方法量身打造的工具接口（类）
 *
 * @author mucongcong
 * @date 2022/05/11 20:03
 * @since
 **/
public class LambdaDemo12 {
    public static void main(String[] args) {
        // 将Stream转换成容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList()); // (1)Stream转换成List
//        Set<String> set = stream.collect(Collectors.toSet()); // (2)Stream转换成Set
//        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length)); // (3)Stream转换成map

        //　将Stream规约成List
        Stream<String> stream2 = Stream.of("I", "love", "you", "too");
        stream2.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // 使用toCollection()指定规约容器的类型
        Stream<String> stream3 = Stream.of("I", "love", "you", "too");
        ArrayList<String> arrayList = stream3.collect(Collectors.toCollection(ArrayList::new));// (3)
        HashSet<String> hashSet = stream3.collect(Collectors.toCollection(HashSet::new));// (4)
    }
}
