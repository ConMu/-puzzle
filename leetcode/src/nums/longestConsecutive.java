package nums;

import java.util.Arrays;

public class longestConsecutive {
    /*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。*/

    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 1,restmp = 1;
        int index = 1;
        while(index < nums.length) {
            if (nums[index] == nums[index - 1] + 1) {
                index++;
                restmp++;
            }else if (nums[index] == nums[index - 1]){
                index ++;
            }else {
                index++;
                restmp = 1;
            }
            res = Math.max(res,restmp);
        }
        return res;

    }


}
