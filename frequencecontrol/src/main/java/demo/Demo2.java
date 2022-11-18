package demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * String - > Map
 *
 * @author mucongcong
 * @date 2022/11/02 15:10
 * @since
 **/
public class Demo2 {
    public static void main(String[] args) {
//        Map map = new HashMap();
//        map.put("AAA", "1");
//        map.put("BBB", "2");
//        map.put("CCC", "3");
//        //1.map转string
//        String jsonString = JSON.toJSONString(map);
//        System.out.println(jsonString);
        String str="{0:10169L,1:70700L}";
        HashMap<Integer,Long> hashMap = JSON.parseObject(str, HashMap.class);
//        Map<Integer, Long> newColumnMap= new HashMap<>();
//        hashMap.entrySet().forEach(x -> newColumnMap.put(x.getKey(), x.getValue()));
//        for (Map.Entry<Integer, Long> integerLongEntry : hashMap.entrySet()) {
//            System.out.println(integerLongEntry.getKey());
//            System.out.println(integerLongEntry.getValue());
//        }
        long businessid = 10169;
        List<Long> defaultGroupBusinessIds = new ArrayList(hashMap.values());
        if (defaultGroupBusinessIds.contains(businessid)) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
