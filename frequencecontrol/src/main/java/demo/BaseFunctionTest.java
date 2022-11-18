package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 基本功能测试：1、相同的appkey一定分到同一个组 2、不同的appkey有可能分到不同组 3、appkey能按比例分配
 * Todo 1.精确系数的影响与选择  2.性能测试
 *
 * @author mucongcong
 * @date 2022/11/18 11:24
 * @since
 **/
public class BaseFunctionTest {
    public static void main(String[] args) {
        int appKeyNums = 100000;

        // k:方案标识，v:比例
        HashMap<String, Integer> map = initExperimentMap();
        RandomSelectorUtils utils = new RandomSelectorUtils(map,100);

        System.out.println("=======" + "一致性判断" + "=======");

        // 一致性判断 相同的appkey一定分到同一个组
        for (int i = 0; i < 10; i++) {
            String s1 = "s" + i;
            String a1 = utils.getHashBound(s1);
            String s2 = "s" + i;
            String a2 = utils.getHashBound(s2);
            System.out.println(a2.equals(a1));
        }
        String s1 = utils.getHashBound("s1");
        String s2 = utils.getHashBound("s1");
        System.out.println(s2.equals(s1));


        System.out.println("=======" + "相异性判断" + "=======");

        // 相异性判断 不同的appkey有可能分到不同组
        for (int i = 0; i < 10; i++) {
            String s = "m" + i;
            String m = utils.getHashBound(s);
            System.out.println("m" + i + "分组到：" + m);
        }

        System.out.println("=======" + "按比例分配" + "=======");

        // 按比例分配 appkey能按比例分配   testMap存储每个key存放的数量
        HashMap<String, Integer> testMap = new HashMap<>();

        //模拟 10000个key下发
        for (int i = 0; i < appKeyNums; i++) {
            String s = "m" + i;
            String m = utils.getHashBound(s);
            int count = testMap.containsKey(m) ? testMap.get(m) : 0;
            testMap.put(m, count + 1);
        }
        double sumCount = 0;
        for (Integer value : testMap.values()) {
            sumCount += value;
        }
        for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
            System.out.println(entry.getKey() + "占比：" + entry.getValue()/sumCount);
        }
    }

    // 初始方案的map
    private static HashMap<String, Integer> initExperimentMap() {
        // k:方案标识，v:比例
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ss", 10);
        map.put("aa", 50);
        map.put("dd", 40);
        return map;
    }

}
