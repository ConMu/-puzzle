package word;
/*https://leetcode-cn.com/problems/count-binary-substrings/submissions/*/
public class CountBinarySubstrings {
    int cnt = 0;
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        int leftIndex = 0, rightIndex = 1;
        while (rightIndex < s.length()) {
            if (s.charAt(leftIndex)=='0'&& s.charAt(rightIndex)=='1'
                    || s.charAt(leftIndex)=='1'&& s.charAt(rightIndex)=='0'){
                getNum(s, leftIndex, rightIndex);
            }
            rightIndex++;
            leftIndex++;
        }
        return cnt;
    }

    private void getNum(String s, int leftIndex, int rightIndex) {
        char c = s.charAt(leftIndex);
        char d = s.charAt(rightIndex);
        while (leftIndex >= 0 && rightIndex < s.length()
                && s.charAt(leftIndex) == c && s.charAt(rightIndex) == d) {
            cnt++;
            leftIndex--;
            rightIndex++;
        }
    }
}
