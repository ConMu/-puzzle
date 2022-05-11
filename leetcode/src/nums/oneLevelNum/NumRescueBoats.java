package nums.oneLevelNum;

import java.util.Arrays;
/*https://leetcode-cn.com/problems/boats-to-save-people/*/
public class NumRescueBoats {
    public static void main(String[] args) {
        int[] nums = {3,5,3,4};
        int limit = 3;
        System.out.println(numRescueBoats(nums, limit));
    }
    public static int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1;
        Arrays.sort(people);
        while (left <= right && people[right] + people[left] > limit) {
            right--;
        }
        int res = people.length - right - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                res++;
            } else {
                right--;
                res++;
            }
        }
        return res;
    }
}
