package word;

public class replaceSpace {
    /*
    * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    *
    * */
    public String replaceSpace(String s) {
        if (s == null || s.length() ==0) return s;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuffer.append('%');
                stringBuffer.append('2');
                stringBuffer.append('0');
            }else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

}
