package elsething;

public class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        // String ad = s.substring(0,n + 1)；
        for(int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(0,n));
        return sb.toString();
    }
}
