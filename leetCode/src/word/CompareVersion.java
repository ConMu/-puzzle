package word;
/*https://leetcode-cn.com/problems/compare-version-numbers/*/
public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        int len = Math.min(s1.length, s2.length);
        for (int i = 0; i < len; i++) {
            int a = getNoZero(s1[i]);
            int b = getNoZero(s2[i]);
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        int index = len;
        if (s1.length > s2.length) {
            while (index < s1.length) {
                int num = getNoZero(s1[index]);
                if (num != 0) {
                    return 1;
                }
                index++;
            }
        } else {
            while (index < s2.length) {
                int num = getNoZero(s2[index]);
                if (num != 0) {
                    return -1;
                }
                index++;
            }
        }
        return 0;
    }

    private static int getNoZero(String s) {
        if (s == null) {
            return 0;
        }
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        return Integer.parseInt(s.substring(index, s.length()));
    }

    public static void main(String[] args) {
        String a = "7.5.2.4";
        String b = "7.5.3";
        System.out.println(compareVersion(a, b));

    }
}
