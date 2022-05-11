package basething.lambda.lambdademo;

//自定义接口
@FunctionalInterface
public interface ConsumerInterface<T>{
    void accept(T t);
}
