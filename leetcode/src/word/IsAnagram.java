package word;
/*s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
https://leetcode.com/problems/valid-anagram/description/*/

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            tmp[c - 'a'] += 1;
        }
        for (int i : tmp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
