package basething.lambda.lammap;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * replaceAll()
 * 该方法签名为replaceAll(BiFunction<? super K,? super V,? extends V> function)，作用是对Map中的每个映射执行function指定的操作，并用function的执行结果替换原来的value，
 * 其中BiFunction是一个函数接口，里面有一个待实现方法R apply(T t, U u)
 *
 * @author mucongcong
 * @date 2022/05/11 15:24
 * @since
 **/
public class LambdaDemo8 {

    public static void main(String[] args) {

    // Java7以及之前替换所有Map中所有映射关系
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            entry.setValue(entry.getValue().toUpperCase());
        }

        // 使用replaceAll()结合匿名内部类实现
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "one");
        map2.put(2, "two");
        map2.put(3, "three");
        map2.replaceAll(new BiFunction<Integer, String, String>(){
            @Override
            public String apply(Integer k, String v){
                return v.toUpperCase();
            }
        });

        // 使用replaceAll()结合Lambda表达式实现
        HashMap<Integer, String> map3 = new HashMap<>();
        map3.put(1, "one");
        map3.put(2, "two");
        map3.put(3, "three");
        map3.replaceAll((k, v) -> v.toUpperCase());
    }
}
