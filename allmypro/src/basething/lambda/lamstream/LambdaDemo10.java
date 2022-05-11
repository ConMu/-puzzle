package basething.lambda.lamstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * forEach()
 * 方法签名为void forEach(Consumer<? super E> action)，作用是对容器中的每个元素执行action指定的动作，也就是对元素进行遍历
 * filter()
 * 函数原型为Stream<T> filter(Predicate<? super T> predicate)，作用是返回一个只包含满足predicate条件元素的Stream
 * distinct()
 * 函数原型为Stream<T> distinct()，作用是返回一个去除重复元素之后的Stream
 * sorted()
 * 排序函数有两个，一个是用自然顺序排序，一个是使用自定义比较器排序，函数原型分别为Stream<T>　sorted()和Stream<T>　sorted(Comparator<? super T> comparator)
 * map()
 * 函数原型为<R> Stream<R> map(Function<? super T,? extends R> mapper)，作用是返回一个对当前所有元素执行执行mapper之后的结果组成的Stream
 * flatmap()
 * 函数原型为<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)，
 * 作用是对每个元素执行mapper指定的操作，并用所有mapper返回的Stream中的元素组成一个新的Stream作为最终返回结果
 *
 * @author mucongcong
 * @date 2022/05/11 16:32
 * @since
 **/
public class LambdaDemo10 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(s -> System.out.println(s));

        // filter()是个中间操作，如果只调用filter()不会有实际计算，因此也不会输出任何信息
        Stream<String> stream1 = Stream.of("I", "love", "you", "too");
        stream1.filter(s -> s.length() == 3)
                .forEach(System.out::println);

        System.out.println("------------------");
        Stream<String> stream2 = Stream.of("I", "love", "you", "too", "too");
        stream2.distinct().forEach(System.out::println);

        System.out.println("------------------");
        Stream<String> stream3 = Stream.of("I", "love", "you", "too");
        stream3.sorted((str1, str2) -> str1.length() - str2.length())
                .forEach(System.out::println);

        System.out.println("------------------");
        Stream<String> stream4 = Stream.of("I", "love", "you", "too");
        stream4.map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("------------------");
        Stream<List<Integer>> stream5 = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream5.flatMap(list -> list.stream())
                .forEach(i -> System.out.println(i));

    }
}
