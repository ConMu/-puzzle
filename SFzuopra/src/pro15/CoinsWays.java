package pro15;

public class CoinsWays {
    //背包问题
    //arr里面是正数组，没有重复值，每个值代表一个货币，每一个都可以使用无限张，
    // 最终找零数目为rest，返回找零的方法数
    public static int way1(int[] arr ,int aim){
        return process(arr,0,aim);
    }

    public static int process(int[] arr ,int index, int rest){
        if (index == arr.length){
            return rest == 0 ? 1:0;
        }
        int ways = 0;
        //arr[index]  0张，1张....不要超过rest
        for (int zhang = 0; arr[index] * zhang < rest; zhang++) {
            ways +=process(arr,index +1,rest-arr[index]*zhang);
        }
        return ways;
    }
}
