package basething.lambda.lamstream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collect()
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
    }
}
