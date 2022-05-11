package nums.oneLevelNum;
/*https://leetcode-cn.com/problems/next-permutation/*/
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int indexLeft, int indexRight) {
        while (indexLeft < indexRight) {
            int tmp = nums[indexLeft];
            nums[indexLeft] = nums[indexRight];
            nums[indexRight] = tmp;
            indexLeft++;
            indexRight--;
        }
    }

    private static void swap(int[] nums, int indexLeft, int indexRight) {
        int tmp = nums[indexLeft];
        nums[indexLeft] = nums[indexRight];
        nums[indexRight] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {5,1,1};
        nextPermutation(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
