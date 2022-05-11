package dinamicplay;
/*https://leetcode-cn.com/problems/arithmetic-slices/description/*/
public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int count = 0;
        //dp[i]表示以i结尾的子区间递增的个数
        for (int i = 2; i < nums.length; i++) {
            if (2*nums[i-1] == nums[i] +nums[i-2]){
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}
