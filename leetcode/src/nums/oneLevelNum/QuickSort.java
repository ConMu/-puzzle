package nums.oneLevelNum;

public class QuickSort {

    public static void qs(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int tmp = nums[low];
        int i = low, j = high;
        while (i < j) {
            while (nums[j] >= tmp && i < j) {
                j--;
            }
            while (nums[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        //10,7,2,4,7,62,3,4,2,1,8,9,19
        swap(nums, low, i);
        qs(nums, low, i - 1);
        qs(nums, i + 1, high);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        qs(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}

