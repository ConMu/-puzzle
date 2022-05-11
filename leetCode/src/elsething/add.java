package elsething;

public class add {
    public int add(int a, int b) {
        while(b != 0) {
            int c = (a&b)<<1;//进位信息
            a ^= b;//无进位信息的位运算
            b = c;
        }
        return a;
    }
}
