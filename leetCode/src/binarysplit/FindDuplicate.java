package binarysplit;

import java.util.Arrays;

/*https://leetcode-cn.com/problems/find-the-duplicate-number/*/
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int h = nums.length-1;//6
        int l = 0;
        int mid = (h + l) / 2;
        while (h >= l) {
            mid = (h + l) / 2;
            if (mid >= nums[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int num = findDuplicate(nums);
        System.out.println(num);
    }

}
