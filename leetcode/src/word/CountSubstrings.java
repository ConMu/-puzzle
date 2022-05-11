package word;

/*https://leetcode-cn.com/problems/palindromic-substrings/submissions/*/
public class CountSubstrings {
    public static int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        boolean[][] flag = new boolean[s.length()][s.length()];

        for (int i = 0; i < flag.length; i++) {
            flag[i][i] = true;
        }
        int count = flag.length;
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int rightIndex = i + j - 1;
                if (rightIndex >= s.length()) {
                    break;
                }
                if (i == 2) {
                    flag[j][rightIndex] = s.charAt(j) == s.charAt(rightIndex);
                }else {
                    flag[j][rightIndex] = flag[j + 1][rightIndex - 1]
                            && (s.charAt(j) == s.charAt(rightIndex));
                }
                if (flag[j][rightIndex]) {
                    count++;
                }
            }
        }
        return count;
    }

    static int cnt = 0;
    public static int countSubstrings2(String s){
        for (int i = 0; i < s.length(); i++) {
            //以i为中心往两边扩充，1.奇数扩，2.偶数扩
            getNum(s, i, i);
            getNum(s, i, i + 1);
        }
        return cnt;
    }

    private static void getNum(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            cnt++;
            start--;
            end++;
        }

    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
