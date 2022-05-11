package nums.oneLevelNum;
/*https://leetcode-cn.com/problems/find-peak-element/*/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    public int findPeakElement2(int[] nums){
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
