package nums;

public class productExceptSelf {
    /*
    * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/product-of-array-except-self
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    *
    * */

    /*public int[] productExceptSelf(int[] nums) {
        int len =nums.length;
        int[] a = new int[len];
        a[0] = 1;
        int[] b = new int[len];
        int[] res = new int[len];
        b[len-1] = 1;
        for (int i = 1; i < len; i++) {
            a[i] = a[i-1] * nums[i-1];
            b[len-i-1] = b[len-i] * nums[len-i];
        }
        for (int i = 0; i < len; i++) {
            res[i] = a[i] * b[i];
        }
        return res;
    }
    */
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int tmp = 1;

        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(test));
    }
}


