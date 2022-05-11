package elsething;

public class findNthDigit {
    public int findNthDigit(int n) {

        int digit =1;
        long start =1,count =9;
        while(n > count){
            n -= count;
            start *= 10;
            digit += 1;
            count = start * digit * 9;
        }
        long a = start + (n -1)/digit;//在a数上
        //返回a的 第 (n-1) %digit 位数
        return Long.toString(a).charAt((n-1)%digit) -'0';


    }
}
