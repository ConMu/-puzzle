package elsething;

public class reverseWords {
    public String reverseWords(String s) {
        s = s.trim();//删除头尾空格
        int j = s.length() - 1, i=j;
        StringBuffer sb = new StringBuffer();
        while(i>=0) {
            while( i >= 0 && s.charAt(i) != ' ') i--;
            // sb.append(s.subString(i+1,j+1) + " ");
            sb.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while( i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        return sb.toString().trim();


    }
}
