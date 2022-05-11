package backtracing;
/*https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/*/
public class MovingCount {
    static int count;
    public static int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        count = 0;
        robGo(0, 0, k, flag, m,n);
        return count;
    }

    private static void robGo(int row, int col, int k, boolean[][] flag, int m, int n) {
        if (row >= 0 && col >= 0 && row < m && col < n) {
            if (notFull(row, col, k) && !flag[row][col]) {
                flag[row][col] = true;
                count++;
                robGo(row + 1, col, k, flag, m, n);
                robGo(row, col + 1, k, flag, m, n);
            }
        }
    }

    private static boolean notFull(int row, int col, int k) {
        return (num(row) + num(col)) <= k;
    }

    private static int num(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {


        System.out.println(movingCount(3, 2, 17));
    }
}
