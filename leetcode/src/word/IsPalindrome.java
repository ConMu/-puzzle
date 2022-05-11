package word;

public class IsPalindrome {
    //https://leetcode-cn.com/problems/palindrome-number/description/
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int tmp = 0;
        while (x > tmp) {
            tmp = tmp * 10 + x % 10;
            x /= 10;
        }
        return x == tmp || x == tmp / 10;
    }
}
