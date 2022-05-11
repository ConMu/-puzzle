package nums.oneLevelNum;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];

        int left = low, right = mid + 1;
        int index = 0;
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                tmp[index++] = nums[left++];
            } else {
                tmp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            tmp[index++] = nums[left++];
        }
        while (right <= high) {
            tmp[index++] = nums[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[low + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int a[] = { 5,4,3,2,1,0 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
