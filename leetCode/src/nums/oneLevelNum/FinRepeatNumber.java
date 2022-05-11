package nums.oneLevelNum;

import java.util.HashSet;

/*https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/*/
public class FinRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        int res = -1;

        for (int integer : nums) {
            boolean contains = integers.contains(integer);
            if (contains) {
                res = integer;
                break;
            }
            integers.add(integer);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber(nums);
    }
}
