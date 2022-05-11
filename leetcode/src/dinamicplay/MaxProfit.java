package dinamicplay;
/*https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/*/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minVal = prices[0];

        for (int i = 0; i < prices.length; i++) {
            minVal = Math.min(prices[i], minVal);
            res = Math.max(res, prices[i] - minVal);
        }
        return res;
    }
}
