package word;

import java.util.*;

public class GenerateParenthesis {
    static ArrayList[] cache = new ArrayList[100];
    public static List<String> generateParenthesis(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String generateParenthesis : generateParenthesis(i)) {
                    for (String parenthesis : generateParenthesis(n - 1 - i)) {
                        ans.add("(" + generateParenthesis + ")" + parenthesis);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    static Map<Integer,List<String>> map = new HashMap<>();
    public static List<String> generateParenthesis2(int n) {
        addMap(n, 0);
        return map.get(n);
    }

    private static void addMap(int n, int index) {
        List<String> strings = new LinkedList<>();
        if (index > n) {
            return;
        }
        if (index == 0) {
            strings.add("");
        }
        for (int i = 0; i < index; i++) {
            int right = index - i - 1;
            for (String s1 : map.get(i)) {
                for (String s2 : map.get(right)) {
                    strings.add("(" + s1 + ")" + s2);
                }
            }
        }
        map.put(index,strings);
        addMap(n, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

}

