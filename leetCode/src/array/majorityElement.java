package array;

public class majorityElement {
    public int majorityElement(int[] nums) {

        // Arrays.sort(nums);
        // return nums[nums.length/2];
        int x = 0;
        int vote = 0;
        for(int num:nums){
            if(vote == 0) x = num;
            vote += x==num ? 1:(-1);
        }
        return x;
    }
}
