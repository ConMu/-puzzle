package word;

import java.util.HashSet;

/*https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/*/
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int res = 1;
//        for (int i = 0; i < s.length(); i++) {
//            int left = i, right = i;
//            int tmp = 1;
////            HashMap<Character, Integer> map = new HashMap<>();
//            HashSet<Character> set = new HashSet<>();
//            while (right < s.length() && !set.contains(s.charAt(right))) {
//                set.add(s.charAt(right));
//                right++;
//                tmp = right - left;
//            }
//            res = Math.max(tmp, res);
//        }
        HashSet<Character> set = new HashSet<>();
        int right = 0;
        for (int left = 0; left < s.length(); left++) {

            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            set.remove(s.charAt(left));
            int len = right - left;
            res = Math.max(res, len);
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
