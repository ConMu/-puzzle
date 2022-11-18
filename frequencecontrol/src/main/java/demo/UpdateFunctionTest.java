package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 修改功能测试  修改后 1.hash环节点变化情况  2.原测试流量分布变化情况
 *
 * @author mucongcong
 * @date 2022/11/18 13:31
 * @since
 **/
public class UpdateFunctionTest {
    public static void main(String[] args) {

        int appKeyNums = 100000;
        // 初始实验分流map，用于后续对照
        HashMap<String, Integer> map = initExperimentMap();
        // 创建一致性hash环
        RandomSelectorUtils utils = new RandomSelectorUtils(map,100);

        System.out.println("=======" + "更新分流情况,方案不变，比例变化" + "=======");

        //获取一致性hash环上所有节点 K:32位hash值，V：对应的分组
        TreeMap<Long, String> oldTeeMap = utils.getTreeMap();
        System.out.println("旧hash环的大小：" + oldTeeMap.size());

        // testMap0存储老的hash环的appKey映射情况  k：appKey  v：映射到的组
        HashMap<String, String> testMap0 = new HashMap<>();

        //模拟 10000个key下发
        for (int i = 0; i < appKeyNums; i++) {
            String s = "m" + i;
            String m = utils.getHashBound(s);
            testMap0.put(s, m);
        }


        // case 1 更新分流情况,方案不变，比例变化
        // mapUpdate：新的分流策略
        HashMap<String, Integer> mapUpdate = new HashMap<>();
        mapUpdate.put("ss", 10);
        mapUpdate.put("aa", 60);
        mapUpdate.put("dd", 30);
        utils.updateHashCircle(mapUpdate);

        TreeMap<Long, String> newTreeMap = utils.getTreeMap();
        System.out.println("新hash环的大小：" + newTreeMap.size());

        double unChangedNodeNum = CompareOldAndNewMap(oldTeeMap,newTreeMap);
        System.out.println("未改变的节点比例：" + unChangedNodeNum/oldTeeMap.size());

        // testMap0存储老的hash环的映射情况  k：appKey  v：映射到的组
        HashMap<String, String> testMap1 = new HashMap<>();

        //新hash环 模拟 10000个key下发
        for (int i = 0; i < appKeyNums; i++) {
            String s = "m" + i;
            String m = utils.getHashBound(s);
            testMap1.put(s, m);
        }

        double unChangedNum = CompareOldAndNewMap(testMap0,testMap1);
        System.out.println("appKey分流后，未改变分组的比例：" + unChangedNum/appKeyNums + "（存在估值偏高的情况）");



        System.out.println("=======" + "更新分流情况,方案增多/减少" + "=======");

        // case 2 更新分流情况,方案增多/减少
        HashMap<String, Integer> map2 = initExperimentMap();

        // 回溯到原来的对照实验组
        utils.updateHashCircle(map2);
        TreeMap<Long, String> oldTeeMap2 = utils.getTreeMap();
        HashMap<String, Integer> mapUpdate2 = new HashMap<>();
        mapUpdate2.put("ss", 20);
        mapUpdate2.put("aa", 30);
        mapUpdate2.put("dd", 20);
        mapUpdate2.put("ee", 20);
        mapUpdate2.put("ff", 10);
        utils.updateHashCircle(mapUpdate2);

        TreeMap<Long, String> newTreeMap2 = utils.getTreeMap();
        double unChangedNodeNum2 = CompareOldAndNewMap(oldTeeMap2,newTreeMap2);
        System.out.println("未改变的节点比例：" + unChangedNodeNum2/oldTeeMap2.size());

        // testMap存储老的hash环的映射情况  k：appKey  v：映射到的组
        HashMap<String, String> testMap2 = new HashMap<>();

        // 新hash环 模拟 10000个key下发
        for (int i = 0; i < appKeyNums; i++) {
            String s = "m" + i;
            String m = utils.getHashBound(s);
            testMap2.put(s, m);
        }

        double unChangedNum2 = CompareOldAndNewMap(testMap0,testMap2);
        System.out.println("appKey分流后，未改变分组的比例：" + unChangedNum2/appKeyNums + "（存在估值偏高的情况）");

    }

    // 初始方案的map
    private static HashMap<String, Integer> initExperimentMap() {
        // k:方案标识，v:比例
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ss", 20);
        map.put("aa", 40);
        map.put("dd", 40);
        return map;
    }

    /*
     * @Description 对比两个Map K，V  返回相同K，V的数量
     *
     * @Param [oldMap, newMap]
     * @return double
     **/
    private static <K,V> double CompareOldAndNewMap(Map<K,V> oldMap, Map<K,V> newMap) {
        double unChangedNum = 0;
        for (Map.Entry<K,V> oldEntry : oldMap.entrySet()) {
            K oldKey = oldEntry.getKey();
            V oldValue = oldEntry.getValue();
            if (newMap.containsKey(oldKey) && newMap.get(oldKey).equals(oldValue)) {
                unChangedNum++;
            }
        }
        return unChangedNum;
    }
}
