package elsething;

public class translateNum {
    public int translateNum(int num) {
        String s = Integer.toString(num);
        int a = 1,b = 1;//a为num == null时的数，b为num.length == 1时的数
        for(int i = 2;i <= s.length();i++){
            String tmp = s.substring(i-2,i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a+b:a;
            b = a;
            a = c;


        }
        return a;
    }
}
