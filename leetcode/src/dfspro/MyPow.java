package dfspro;
/*https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/*/
public class MyPow {
    public static double myPow(double x, int n) {
        double res = 1;
        if (n == 0) {
            return 1;
        } else if (n >= 1) {
            while (n > 0) {
                res = res * x;
                n--;
            }
        } else {
            while (n < 0) {
                res = res / x;
                n++;
            }
        }
        return res;
    }


    public static double myPow2(double x, int n) {
        double res = 1.0;
        long b = n;
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) ==1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }


        public static void main(String[] args) {
        System.out.println(myPow2(2.00000,10));

    }
}
