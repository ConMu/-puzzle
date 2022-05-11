package pro09;



public class BitMap {
    //布隆过滤器
    public static void main(String[] args) {

        int a = 0;//a  32 bit
        int[] arr = new int[10];//32bit *10 =320位

        //arr[0] int 0-31
        //arr[1] int 32-63

        //如何得到第 i 位的信息
        int i = 178;
        int numIndex = i / 32;
        int bitIndex = i % 32;

        //拿到i位状态
        int s = ( (arr[numIndex]) >> (bitIndex)  & 1);

        //第 i 位状态改成 1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));

//        第 i 位改成0
        arr[numIndex] = arr[numIndex] & ( ~ (1<<(bitIndex)));


    }



}
