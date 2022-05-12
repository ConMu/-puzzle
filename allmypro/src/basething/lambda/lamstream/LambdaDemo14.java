package basething.lambda.lamstream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * join()
 * 字符串拼接时使用Collectors.joining()生成的收集器
 *
 * @author mucongcong
 * @date 2022/05/12 10:39
 * @since
 **/
public class LambdaDemo14 {
    public static void main(String[] args) {
        // 使用Collectors.joining()拼接字符串
        Stream<String> stream = Stream.of("I", "love", "you");
//        String joined = stream.collect(Collectors.joining());// "Iloveyou"
//        String joined = stream.collect(Collectors.joining(","));// "I,love,you"
        String joined = stream.collect(Collectors.joining(",", "{", "}"));// "{I,love,you}"

        // 输出为： A1B1C1 A2B2C2 A3B3C3 中间操作是懒惰的，也就是中间操作不会对数据做任何操作，直到遇到了最终操作。
        // 而最终操作，都是比较热情的。他们会往前回溯所有的中间操作。也就是当执行到最后的forEach操作的时候，
        // 它会回溯到它的上一步中间操作，上一步中间操作，又会回溯到上上一步的中间操作，...，直到最初的第一步。
        // 第一次forEach执行的时候，会回溯peek 操作，然后peek会回溯更上一步的limit操作，
        // 然后limit会回溯更上一步的peek操作，顶层没有操作了，开始自上向下开始执行，输出：A1B1C1 第二次forEach执行的时候，
        // 然后会回溯peek 操作，然后peek会回溯更上一步的limit操作，然后limit会回溯更上一步的peek操作，顶层没有操作了，开始自上向下开始执行，输出：A2B2C2
        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .limit(3)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));


        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .skip(6)  // 执行到skip，这个操作的意思就是跳过，下面的都不要执行了，也就是就相当于循环里面的continue，结束本次循环
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));

    }
}
