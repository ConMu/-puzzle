package island;
/*https://leetcode-cn.com/problems/max-area-of-island/*/
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int tmp = findMyland(grid,i,j,row,col);
                    res = Math.max(res, tmp);
                }
            }
        }
        return res;

    }

    private static int findMyland(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        int a = findMyland(grid, i - 1, j, row, col);
        int b = findMyland(grid, i + 1, j, row, col);
        int c = findMyland(grid, i, j - 1, row, col);
        int d = findMyland(grid, i, j + 1, row, col);
        return ans + a + b + c + d;
    }

    public static void main(String[] args) {
        int[][] island = {{1, 0}, {1, 1}};
        System.out.println(maxAreaOfIsland(island));

    }
}
