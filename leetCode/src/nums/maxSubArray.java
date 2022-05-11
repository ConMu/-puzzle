package nums;

public class maxSubArray {

    /*
     *
     *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和.
     * */


    public static int maxSubArray(int[] nums) {
        int res = nums[0],pre = 0;
        for (int num : nums) {
            pre = Math.max(num,pre + num);
            res = Math.max(pre,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test));
    }


}
