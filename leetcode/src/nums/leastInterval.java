package nums;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class leastInterval {
    /*给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。
    其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，
    并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，
    CPU 可以完成一个任务，或者处于待命状态。

    然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，
    因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

    你需要计算完成所有任务所需要的 最短时间 。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/task-scheduler
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


    class Solution {
        public int leastInterval(char[] tasks, int n) {
            //关键参数：执行次数最大值、执行次数为最大值的任务数量,
            // 最短时间为Math.max((maxTime -1)*(n+1) + maxCount,tasks.length);
            //注意  ： 无法直接遍历Map集合，需要使用map.entrySet转为Set数组，然后用iter进行遍历
            Map<Character, Integer> map = new HashMap<>();
            int maxTime = 0;
            for (char task : tasks) {
                int exec = map.getOrDefault(task,0) + 1;
                map.put(task,exec);//计数
                maxTime = Math.max(maxTime,exec);
            }
            int maxCount = 0;
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                if (maxTime == entry.getValue()) {
                    maxCount ++;
                }
            }
            return Math.max((maxTime -1)*(n+1) + maxCount,tasks.length);

        }
    }
}
