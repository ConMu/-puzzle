package array;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        // int[] res = new int[2];
        while(left < right){
            if(nums[left] + nums[right] > target) right--;
            if(nums[left] + nums[right] < target) left++;
            if(nums[left] + nums[right] == target) break;
        }
        return new int[]{nums[left],nums[right]};

    }
}
