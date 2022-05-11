package basething.lambda.lambdademo;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author mucongcong
 * @date 2022/05/10 10:05
 * @since
 **/
public class LambdaDemo1 {
    public static void main(String[] args) {
        // 普通创建线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread is running ..");
//            }
//        }).start();

        //lambda 创建线程  如果函数体有多行，可以用大括号括起来
//        new Thread(
//                    () -> {
//                        System.out.println("thread is running ...");
//                        System.out.println("two functions...");
//                    }
//                ).start();

        // JDK7 匿名内部类写法
//        List<String> list = Arrays.asList("I", "love", "you", "too");
//        Collections.sort(list, new Comparator<String>(){// 接口名
//            @Override
//            public int compare(String s1, String s2){// 方法名
//                if(s1 == null) {
//                    return -1;
//                }
//                if(s2 == null) {
//                    return 1;
//                }
//                return s1.length()-s2.length();
//            }
//        });

        // JDK8 Lambda表达式写法
//        List<String> list = Arrays.asList("I", "love", "you", "too");
//        Collections.sort(list, (s1, s2) ->{// 省略参数表的类型
//            if(s1 == null) {
//                return -1;
//            }
//            if(s2 == null) {
//                return 1;
//            }
//            return s1.length()-s2.length();
//        });

//        BinaryOperator<Long> add = (Long x, Long y) -> {
//            Long a = x * y;
//            Long b = x / y;
//            return a /b;
//        };// 4

        // Lambda表达式的书写形式
//        Runnable run = () -> System.out.println("Hello World");// 1  无参函数
//        ActionListener listener = event -> System.out.println("button clicked");// 2  有参函数+类型机制推断
//        Runnable multiLine = () -> {// 3 代码块
//            System.out.print("Hello");
//            System.out.println(" Hoolee");
//        };
//        BinaryOperator<Long> add = (Long x, Long y) -> x + y;// 4
//        BinaryOperator<Long> addImplicit = (x, y) -> x + y;// 5 类型推断

        //自定义函数接口使用lambda表达式书写
        ConsumerInterface<String> consumer = s -> System.out.println(s);

        MyStream<String> stream = new MyStream<String>();
        stream.myForEach(str -> System.out.println(str));// 使用自定义函数接口书写Lambda表达式

    }




}
