package array;

import java.util.HashSet;
import java.util.Set;

public class findRepeatNumber {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            int repeat = -1;
            for (int num:nums) {
                if(!set.add(num)){
                    repeat = num;
                    break;
                }
            }
            return repeat;
        }
    }
}
