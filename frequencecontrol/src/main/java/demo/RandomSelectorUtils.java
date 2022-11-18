package demo;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.*;

/**
 * @author mucongcong
 * @date 2022/11/17 17:52
 * @since
 **/
public class RandomSelectorUtils {

    private static final int seed = 42;

    private TreeMap<Long,String> treeMap;

    // 精准系数，大于1，越大越精准，分割越精细，hash环越大,初始化hash环越慢
    private Integer precision;

    // 一致性hash环，底层红黑树，查询效率 log2N
    public TreeMap<Long, String> getTreeMap() {
        return treeMap;
    }

    // Todo 缓存优化
    /*
     * @Description 构造方法
     *
     * @Param [initHashMap]
     * @return
     **/
    public RandomSelectorUtils(HashMap<String, Integer> initHashMap,Integer precision) {
        if (precision == null || precision < 0) {
            precision = 1;
        }
        this.precision = precision;
        initHashCirCle(initHashMap, precision);
    }

    private void initHashCirCle(HashMap<String, Integer> initHashMap, Integer precision) {
        this.treeMap = new TreeMap<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : initHashMap.entrySet()) {
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            for (int i = 0; i < value * precision; i++) {
                String bound = key + "&&VN" + String.valueOf(i);
                byte[] bytes = bound.getBytes();
                HashFunction guava2 = Hashing.murmur3_32(seed);
                HashCode guavaCode2 = guava2.hashBytes(bytes);
                treeMap.put(Long.parseLong(guavaCode2.toString(), 16), key);
            }
        }
    }

    // Todo 更新优化
    // 更新hash环
    public void updateHashCircle(HashMap<String, Integer> initHashMap) {
        initHashCirCle(initHashMap, this.precision);
    }

    /*
     * @Description 获取appKey对应的组
     *
     * @Param [appKey]
     * @return java.lang.String
     **/
    public String getHashBound(String appKey) {
        byte[] bytes = appKey.getBytes();
        HashFunction guava2 = Hashing.murmur3_32(seed);
        HashCode guavaCode2 = guava2.hashBytes(bytes);
        long randomNumber = Long.parseLong(guavaCode2.toString(), 16);
        Long bound = treeMap.ceilingKey(randomNumber);
        if (bound == null) {
            return treeMap.get(treeMap.firstKey());
        }
        return treeMap.get(treeMap.ceilingKey(randomNumber));
    }

}
