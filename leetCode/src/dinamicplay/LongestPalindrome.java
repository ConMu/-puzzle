package dinamicplay;
//https://leetcode-cn.com/problems/longest-palindromic-substring/
public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }
        int lenS = s.length();
        boolean[][] flag = new boolean[lenS][lenS];
        for (int i = 0; i < lenS; i++) {
            flag[i][i] = true;
        }
        int getMaxLen = 1;
        int beginNum = 1, endNum = 1;
        for (int len = 2; len <= lenS; len++) {
            for (int beginIndex = 0; beginIndex < lenS; beginIndex++) {
                int endIndex = beginIndex + len - 1;
                if (endIndex >= lenS) {
                    break;
                }
                if (s.charAt(beginIndex) != s.charAt(endIndex)) {
                    flag[beginIndex][endIndex] = false;
                } else if (len == 2) {
                    flag[beginIndex][endIndex] = true;
                } else {
                    flag[beginIndex][endIndex] = flag[beginIndex + 1][endIndex - 1];
                }
                if (flag[beginIndex][endIndex] && len > getMaxLen) {
                    getMaxLen = len;
                    beginNum = beginIndex;
                    endNum = endIndex;
                }
            }
        }
        return s.substring(beginNum, endNum + 1);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));

    }

}
