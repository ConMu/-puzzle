package process;

public class maxValue {
    public int maxValue(int[][] grid) {
        //     int row = grid.length;
        //     int col = grid[0].length;
        //     return most(grid,row-1,col-1);
        // }

        // int most(int[][] grid,int r,int c){
        //     if(r < 0 || c < 0 || r > grid.length-1 || c > grid[0].length-1) return -1;
        //     if(r == 0 && c == 0) return grid[0][0];
        //     return Math.max(most(grid,r-1,c) + grid[r][c],most(grid,r,c -1) + grid[r][c]);

        int m = grid.length,n = grid[0].length;
        // int[][] nums = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(i == 0 && j ==0) continue;
                if(i == 0) grid[i][j] += grid[i][j-1];
                else if(j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
