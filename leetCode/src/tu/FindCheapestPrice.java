package tu;

import java.util.Arrays;

/*https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/*/
public class FindCheapestPrice {
    static int res = Integer.MAX_VALUE;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (dst == src) {
            return 0;
        }
        int[][] cache = new int[n][n];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache.length; j++) {
                if (i == j) {
                    cache[i][j] = 0;
                } else {
                    cache[i][j] = 9999;
                }
            }
        }
        for (int[] ints : flights) {
            cache[ints[0]][ints[1]] = ints[2];
        }
        dfs(cache, src, dst, k,0);
        return res = res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void dfs(int[][] cache, int src, int dst, int k, int curNum) {
        if (src == dst) {
            res = Math.min(res, curNum);
        }
        if (k < 0) {
            return;
        }
        for (int i = 0; i < cache[0].length; i++) {
            if (cache[src][i] != 9999) {
                dfs(cache, i, dst, k - 1, curNum + cache[src][i]);
            }
        }
    }


    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
            final int INF = 10000 * 101 + 1;
            int[][] f = new int[k + 2][n]; //dp[t][i] 表示通过恰好 tt 次航班，从出发城市src到达城市 i 需要的最小花费
            for (int i = 0; i < k + 2; i++) {
                Arrays.fill(f[i], INF);
            }
            f[0][src] = 0;
            for (int t = 1; t < k + 2; t++) {
                for (int[] flight : flights) {
                    int j = flight[0], i = flight[1], cost = flight[2];
                    f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
                }
            }
            int ans = INF;
            for (int i = 1; i <= k + 1; i++) {
                ans = Math.min(ans, f[i][dst]);
            }
            return ans == INF ? -1 : ans;

    }


    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(findCheapestPrice2(n, edges, 0, 0, 0));
    }

    /*3
[[0,1,100],[1,2,100],[0,2,500]]
0
2
1*/
}
