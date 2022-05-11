package array;

import java.util.HashMap;
import java.util.Map;

public class singleNumber02 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num:nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(int num:nums) {
            if(map.get(num) == 1) res = num;
        }
        return res;
    }
}
