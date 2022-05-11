package dinamicplay;
/*https://leetcode-cn.com/problems/range-sum-query-immutable/description/*/
public class NumArray {
    static int[] indexArray;

    public NumArray(int[] nums) {
        indexArray = new int[nums.length];
        int tmp = 0;
        for(int i = 0; i < nums.length; i++ ){
            tmp += nums[i];
            indexArray[i] = tmp;
        }
    }

    public static int sumRange(int left, int right) {
        if (left == 0) {
            return indexArray[right];
        }
        return (indexArray[right] - indexArray[left - 1]);
    }

    public static void main(String[] args) {
//        int[] a= {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(sumRange(2, 5));

    }
}
