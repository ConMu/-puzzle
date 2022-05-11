package island;

import javax.swing.plaf.IconUIResource;

/*https://leetcode-cn.com/problems/number-of-islands/*/
public class NumIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        boolean[][] flag = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (findMyisland(grid, flag,i,j,row,col)){
                    count++;
                }
            }
        }


        return count;

    }

    private static boolean findMyisland(char[][] grid, boolean[][] flag, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return false;
        }
        if (grid[i][j] == '1' && !flag[i][j]) {
            flag[i][j] = true;
            findMyisland(grid, flag, i - 1, j, row, col);
            findMyisland(grid, flag, i + 1, j, row, col);
            findMyisland(grid, flag, i, j - 1, row, col);
            findMyisland(grid, flag, i, j + 1, row, col);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] isLand = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '1'}};
        System.out.println(numIslands(isLand));

    }
}
