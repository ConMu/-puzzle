package word;

import java.util.LinkedList;
import java.util.List;
/*https://leetcode-cn.com/problems/text-justification/*/
public class FullJustify {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<>();
        if(words == null){
            return list;
        }

        for(int i = 0;i < words.length; i++){
            int start = i;
            int preCount = 0;
            int curCount = 0;
            while (i < words.length && isOkNum(curCount, maxWidth, i - start + 1, words[i])) {
                preCount = curCount;
                curCount += words[i].length();
                i++;
            }
            int end = i;

            int fillCount = end - start-1;//填补的空隙数
            int fullNum = maxWidth - curCount;//填补的字符个数
            int evFill;
            int moFill;
            if (fillCount != 0) {
                evFill = fullNum / fillCount;//平均填补字符个数
                moFill = fullNum % fillCount;//左侧多余的个数
            } else {
                evFill = fullNum;
                moFill = 0;
            }

            StringBuilder sb = new StringBuilder();
            if (end == words.length) {
                for(int j = start; j < end;j++){
                    if (j == end - 1) {
                        sb.append(words[j]);
                        while (fullNum > 0) {
                            sb.append(' ');
                            fullNum--;
                        }
                        list.add(sb.toString());
                        return list;
                    }
                    sb.append(words[j]);
                    sb.append(' ');
                    fullNum--;
                }
            }
            if (fillCount != 0) {
                for (int j = start; j < end; j++) {
                    if (j != end - 1) {
                        sb.append(words[j]);
                        int tmpEv = evFill;
                        while (tmpEv > 0) {
                            sb.append(' ');
                            tmpEv--;
                        }
                        if (moFill > 0) {
                            sb.append(' ');
                            moFill--;
                        }
                    } else {
                        sb.append(words[j]);
                    }
                }
            } else {
                sb.append(words[start]);
                int tmpEv = evFill;
                while (tmpEv > 0) {
                    sb.append(' ');
                    tmpEv--;
                }
            }

            list.add(sb.toString());
            i = end-1;
        }
        return list;
    }

    private static boolean isOkNum(int curCount, int maxWidth, int num, String s) {
        return (num - 1) + curCount +s.length() <= maxWidth;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> strings = fullJustify(s, maxWidth);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
