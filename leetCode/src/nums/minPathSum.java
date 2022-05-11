package nums;

public class minPathSum {
    /*给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。*/

    /*class Solution {
        //OverTime
        public int minPathSum(int[][] grid) {
            int res = 0;
            int col = grid.length;
            int row = grid[0].length;

            return getMinNum(grid, col - 1, row - 1);
        }

        private int getMinNum(int[][] grid, int m, int n) {
            if (m == 0 && n == 0) {
                return grid[0][0];
            } else if (m == 0 && n != 0) {
                return getMinNum(grid, m, n - 1) + grid[m][n];
            } else if (m != 0 && n == 0) {
                return getMinNum(grid, m - 1, n) + grid[m][n];
            }

            int res = Math.min(getMinNum(grid, m - 1, n), getMinNum(grid, m, n - 1)) + grid[m][n];
            return res;
        }
    }*/


    public int minPathSum(int[][] grid) {
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i==0 && j==0)continue;
                else if (i==0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else if (j==0){
                    grid[i][j] = grid[i-1][j]+ grid[i][j];
                }else {
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
