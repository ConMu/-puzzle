package dinamicplay;
/*https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/*/
public class FindIntegers {
    public int findIntegers(int n) {
        int[] dp = new int[31];
        //dp[t] ：  表示高度为 t+1、根结点为 0 的满二叉树中，不包含连续 1 的从根结点到叶结点的路径数量。
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; i++) {//0-30
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int pre = 0;//记录上一个位的状态
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            int tmp = 1 << i;//跑到第i+1位 对应dp[i+1]
            if ((n & tmp) != 0) {
                //该位上为1
                n -= tmp;//可操作可不操作
                res += dp[i + 1];//以该位为0的dp都符合要求
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            if (i == 0) {
                ++res;
            }
        }
        return res;
    }
}
