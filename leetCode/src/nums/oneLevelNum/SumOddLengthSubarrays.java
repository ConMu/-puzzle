package nums.oneLevelNum;

public class SumOddLengthSubarrays {
    public static int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length+1];
        int tmp = 0;
        for(int i = 1;i< preSum.length;i++){
            tmp += arr[i-1];
            preSum[i] = tmp;
        }
        int res =0;
        for(int i = 0; i < preSum.length; i++){
            for(int sz = 1; i+sz < preSum.length;sz+=2){
                res += preSum[i+sz] - preSum[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));

    }
}
