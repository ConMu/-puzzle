package dinamicplay;
/*https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/*/
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length <= 1) {
            return res;
        }
        for (int i = 1; i < prices.length; i++) {
            res += Math.max((prices[i] - prices[i - 1]), 0);
        }
        return res;
    }


}
