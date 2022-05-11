package basething.lambda.lambdademo;

import java.util.List;

/**
 * @author mucongcong
 * @date 2022/05/10 10:25
 * @since
 **/
public class MyStream<T> {
    private List<T> list;

    public void myForEach(ConsumerInterface<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
