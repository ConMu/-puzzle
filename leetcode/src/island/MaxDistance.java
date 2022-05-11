package island;

import java.util.LinkedList;
import java.util.Queue;

/*https://leetcode-cn.com/problems/as-far-from-land-as-possible/*/
public class MaxDistance {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int n;
    int[][] grid;
    public int maxDistance(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, getMinDis(i, j));
                }
            }
        }
        return ans;

    }

    private int getMinDis(int i, int j) {
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, 0});
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            int[] f = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = f[0] + dx[k], ny = f[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (!vis[nx][ny]) {
                    queue.offer(new int[]{nx, ny, f[2] + 1});
                    vis[nx][ny] = true;
                    if (grid[nx][ny] == 1) {
                        return f[2] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
