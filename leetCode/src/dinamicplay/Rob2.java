package dinamicplay;

public class Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int ca1 = dp(0, nums.length - 2,nums);
        int ca2 = dp(1, nums.length - 1,nums);
        return Math.max(ca1, ca2);
    }

    private int dp(int start, int end, int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;

    }

}
