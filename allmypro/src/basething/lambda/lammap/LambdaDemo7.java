package basething.lambda.lammap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * forEach()
 *该方法签名为void forEach(BiConsumer<? super K,? super V> action)，作用是对Map中的每个映射执行action指定的操作
 *
 * @author mucongcong
 * @date 2022/05/11 15:24
 * @since
 **/
public class LambdaDemo7 {

    public static void main(String[] args) {
        // Java7以及之前迭代Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        // 使用forEach()结合匿名内部类迭代Map
        map.forEach(new BiConsumer<Integer, String>(){
            @Override
            public void accept(Integer k, String v){
                System.out.println(k + "=" + v);
            }
        });

        // 使用forEach()结合Lambda表达式迭代Map
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
