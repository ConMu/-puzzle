package dinamicplay;

/*https://leetcode-cn.com/problems/coin-change/*/
public class CoinChange {

    //定义 f(i, j) 表示选择了 coins 的前 i 项（怎么选的不关心），且组成 j 元需要的最少硬币数。
    public static int coinChange(int[] coins, int amount) {
        int res = getMinCoin(coins, amount,new int[amount]);
        return res;
    }

    private static int getMinCoin(int[] coins, int rem, int[] count) {

        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        //记忆化搜索
        if (count[rem-1] != 0) {
            return count[rem - 1];
        }
        int index = Integer.MAX_VALUE;
        for (int coin : coins) {
            int minCoin = getMinCoin(coins, rem - coin, count);
            if (minCoin != -1) {
                index = Math.min(minCoin, index);
            }
        }
        if (index != Integer.MAX_VALUE) {
            index = index + 1;
            count[rem-1] = index;
            return index;
        }
        count[rem - 1] = -1;
        return -1;

    }

    public static void main(String[] args) {
        int[] coin = {2};
        int amount = 3;
        System.out.println(coinChange(coin, amount));

    }
}
