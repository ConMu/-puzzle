package array;

public class movingCount {
    public int movingCount(int m, int n, int k) {
        if(k == 0){
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for(int i = 0;i < m ;i++){
            for(int j = 0; j < n; j++){
                if((i == 0 && j == 0 ) || get(i) + get(j) > k) {
                    continue;
                }
                if(i - 1 >= 0){
                    vis[i][j] |= vis[i - 1][j];
                }
                if(j - 1 >= 0 ){
                    vis[i][j] |=vis[i][j - 1];
                }
                ans += vis[i][j] ? 1:0;
            }
        }
        return ans;
    }
    public int get (int i) {
        int res = 0;
        res = i%10 +i/10;
        return res;
    }
}
