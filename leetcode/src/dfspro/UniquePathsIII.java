package dfspro;


/*https://leetcode-cn.com/problems/unique-paths-iii/*/
public class UniquePathsIII {
    static int count = 0;
    public static int uniquePathsIII(int[][] grid) {
        int fromRow = 0,fromCol = 0;
        int toRow = 0, toCol = 0;
        int zeroNum = 0;
       
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fromRow = i;
                    fromCol = j;
                }
                if (grid[i][j] == 2) {
                    toRow = i;
                    toCol = j;
                }
                if (grid[i][j] == 0) {
                    zeroNum++;
                }
            }
        }

        dfs(grid, fromRow, fromCol, toRow, toCol, 0,zeroNum);
        return count;
    }

    private static void dfs(int[][] grid, int fromRow, int fromCol, int toRow, int toCol, int flagNum, int zeroNum) {
        if (fromRow < 0 || fromCol < 0 || fromRow > grid.length-1
                || fromCol > grid[0].length-1 || grid[fromRow][fromCol] == -1) {
            return;
        }
        if (grid[fromRow][fromCol] == 2 && flagNum == zeroNum + 1) {
            count++;
        }
        if (grid[fromRow][fromCol] == 0 || grid[fromRow][fromCol] == 1) {
            grid[fromRow][fromCol] = -1;
            flagNum++;
            dfs(grid, fromRow, fromCol + 1, toRow, toCol, flagNum, zeroNum);
            dfs(grid, fromRow, fromCol - 1, toRow, toCol, flagNum, zeroNum);
            dfs(grid, fromRow + 1, fromCol, toRow, toCol, flagNum, zeroNum);
            dfs(grid, fromRow - 1, fromCol, toRow, toCol, flagNum, zeroNum);
            flagNum--;
            grid[fromRow][fromCol] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{0,2,0,0,0},{0,0,0,1,0}};
        System.out.println(uniquePathsIII(nums));

    }
}
