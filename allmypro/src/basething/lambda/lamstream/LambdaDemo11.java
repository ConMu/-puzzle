package basething.lambda.lamstream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * reduce()
 * reduce操作可以实现从一组元素中生成一个值，sum()、max()、min()、count()等都是reduce操作，将他们单独设为函数只是因为常用。reduce()的方法定义有三种重写形式：
 *
 * Optional<T> reduce(BinaryOperator<T> accumulator)   Optional是（一个）值的容器，使用它可以避免null值的麻烦
 * T reduce(T identity, BinaryOperator<T> accumulator)
 * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 *
 *
 * @author mucongcong
 * @date 2022/05/11 18:53
 * @since
 **/
public class LambdaDemo11 {
    public static void main(String[] args) {
        // 从一组单词中找出最长的单词
        Stream<String> stream = Stream.of("I", "love", "you", "too");

        Optional<String> reduce = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println(reduce.get());

//        Optional<String> reduce1 = stream.max((s1, s2) -> s1.length() - s2.length());
//        System.out.println(reduce1.get());


        // 求单词长度之和
        Stream<String> stream2 = Stream.of("I", "love", "you", "too");
        // reduce  0: 初始默认值   (sum, str) -> sum+str.length() 累加器   (a, b) -> a+b 部分和拼接器，并行执行时才会用到
        Integer lengthSum = stream2.reduce(0,(sum, str) -> sum+str.length(),(a, b) -> a+b);


        // int lengthSum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
    }
}
