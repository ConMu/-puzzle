package binarysplit;

import java.util.Arrays;

/*https://leetcode-cn.com/problems/longest-increasing-subsequence/*/
public class LengthOfLIS {
    public static boolean lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int[] maxPlus = getMaxPlus(nums);
        int[] maxPlus2 = getMaxPlus2(nums);
        Arrays.sort(maxPlus);
        Arrays.sort(maxPlus2);

        return maxPlus[maxPlus.length - 1] == maxPlus2[maxPlus2.length - 1];
    }

    private static int[] getMaxPlus2(int[] nums) {
        int[] res = new int[nums.length];//res[i]表示0-i最长增长序列，必须选中i

        for (int i = 0; i < nums.length; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmp = Math.max(res[j] + 1, tmp);
                }
            }
            res[i] = tmp;
        }
        return res;
    }



    private static int[] getMaxPlus(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[len - 1] = 1;
        for (int i = len-2; i >= 0 ; i--) {
            int maxValue = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    maxValue = Math.max(res[j] + 1, maxValue);
                }
            }
            res[i] = maxValue;
        }
        return res;
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                int left = 0;
                int right = len-1;
                int pos = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        left = mid+1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }



    public static void main(String[] args) {
//        int[] nums = {1,3,6,7,9,4,10,5,6};
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS2(nums));

    }
}
