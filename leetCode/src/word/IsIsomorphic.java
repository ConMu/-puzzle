package word;

//https://leetcode-cn.com/problems/isomorphic-strings/submissions/
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char ss = s.charAt(i);
//            char tt = t.charAt(i);
//            if (!map1.containsKey(ss) && !map2.containsKey(tt)) {
//                map1.put(ss, i);
//                map2.put(tt, i);
//            }else if (!map1.containsKey(ss) || !map2.containsKey(tt)) {
//                return false;
//            } else {
//                if (map1.get(ss) != map2.get(tt)) {
//                    return false;
//                }
//                map1.put(ss, i);
//                map2.put(tt, i);
//            }
//        }

        int[] indexOfs = new int[256];
        int[] indexOft = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (indexOfs[sc] != indexOft[tc]) {
                return false;
            }
            indexOfs[sc] = i + 1;
            indexOft[tc] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "aa";
        String b = "ab";
        System.out.println(isIsomorphic(a,b));
    }
}
