package word;

import java.util.LinkedList;
import java.util.List;
/*https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/*/
public class LetterCombinations {


    public static List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null) {
            return list;
        }
        char[] chars = digits.toCharArray();
        dfs(chars, 0, chars.length,list,new StringBuffer());
        return list;
    }

    private static void dfs(char[] chars, int index, int length, List<String> list, StringBuffer stringBuffer) {
        if (index == length ) {
            list.add(new String(stringBuffer));
            return;
        }
        char[] words = getWord(chars, index);
        for (int i = 0; i < words.length; i++) {
            stringBuffer.append(words[i]);
            dfs(chars, index + 1, length, list, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    private static char[] getWord(char[] chars, int index) {
        char aChar = chars[index];
        if (aChar == '2') {
            return new char[]{'a', 'b', 'c'};
        }
        if (aChar == '3') {
            return new char[]{'d', 'e', 'f'};
        }
        if (aChar == '4') {
            return new char[]{'g', 'h', 'i'};
        }
        if (aChar == '5') {
            return new char[]{'j', 'k', 'l'};
        }
        if (aChar == '6') {
            return new char[]{'m', 'n', 'o'};
        }if (aChar == '7') {
            return new char[]{'p', 'q', 'r','s'};
        }
        if (aChar == '8') {
            return new char[]{'t', 'u', 'v'};
        }
        if (aChar == '9') {
            return new char[]{'w', 'x', 'y','z'};
        }
        return null;
    }

    public static void main(String[] args) {
        String de = "23";
        System.out.println(letterCombinations(de));

    }
}
