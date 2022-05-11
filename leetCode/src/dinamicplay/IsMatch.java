package dinamicplay;
/*https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/*/
public class IsMatch {
    public static boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        //flag[i][j] 表示s的前i个与p的前j个是否匹配,初始[0][0] 为true
        boolean[][] flag = new boolean[slen + 1][plen + 1];
        flag[0][0] = true;
        for (int i = 0; i <= slen; i++) {
            for (int j = 0; j <= plen; j++) {
                if (j == 0) {
                    flag[i][j] = i == 0;
                } else {//j!=0
                    if (p.charAt(j - 1) != '*' ){
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            flag[i][j] = flag[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            flag[i][j] |= flag[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            flag[i][j] |= flag[i - 1][j];
                        }
                    }
                }
            }
        }
        return flag[slen][plen];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
