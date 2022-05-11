package word;
/*https://leetcode.com/problems/longest-palindrome/description/*/
public class LongestPalindrome {
    //使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
    public int longestPalindrome(String s) {
        int[] res = new int[256];

        for (char c : s.toCharArray()) {
            res[c]++;
        }
        int count = 0;
        for (int re : res) {
            count += (re / 2) * 2;
        }
        if (count < s.length()) {
            count++; // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return count;
    }
}
