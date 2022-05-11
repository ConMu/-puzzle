package basething.lambda.lammap;

import java.util.HashMap;

/**
 * getOrDefault()
 *方法签名为V getOrDefault(Object key, V defaultValue)，作用是按照给定的key查询Map中对应的value，如果没有找到则返回defaultValue
 * putIfAbsent()
 *方法签名为V putIfAbsent(K key, V value)，作用是只有在不存在key值的映射或映射值为null时，才将value指定的值放入到Map中，否则不对Map做更改．
 * remove()
 * 只有在当前Map中**key正好映射到value时**才删除该映射，否则什么也不做
 * replace()
 * replace(K key, V value)，只有在当前Map中**key的映射存在时**才用value去替换原来的值，否则什么也不做．
 * replace(K key, V oldValue, V newValue)，只有在当前Map中**key的映射存在且等于oldValue时**才用newValue去替换原来的值，否则什么也不做．
 * replaceAll()
 * 该方法签名为replaceAll(BiFunction<? super K,? super V,? extends V> function)，作用是对Map中的每个映射执行function指定的操作，并用function的执行结果替换原来的value，
 * 其中BiFunction是一个函数接口，里面有一个待实现方法R apply(T t, U u)
 *
 * @author mucongcong
 * @date 2022/05/11 15:24
 * @since
 **/
public class LambdaDemo9 {

    public static void main(String[] args) {
        // 查询Map中指定的值，不存在时使用默认值
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        // Java7以及之前做法
        if(map.containsKey(4)){ // 1
            System.out.println(map.get(4));
        }else{
            System.out.println("NoValue");
        }
        // Java8使用Map.getOrDefault()
        System.out.println(map.getOrDefault(4,"NoValue"));

        map.remove(1);
        map.forEach((k, v) -> System.out.println(k + "=" + v));

    }
}
