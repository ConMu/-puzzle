package nums.oneLevelNum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*https://leetcode-cn.com/problems/3sum/*/
public class ThreeSum {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new LinkedList<>();
//        int len = nums.length;
//        if (len < 3) {
//            return list;
//        }
//        Arrays.sort(nums);
//
//        for (int i = 0; i < len - 2; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            LinkedList<Integer> integers = new LinkedList<>();
//            integers.add(nums[i]);
//            dfs(i, len, nums[i], nums,1, list,integers);
//        }
//        return list;
//
//
//    }
//
//    private static void dfs(int index, int len, int num, int[] nums, int count, List<List<Integer>> list, LinkedList<Integer> integers) {
//        if (num > 0 || (count == 3 && num != 0)) {
//            return;
//        }
//        if (count == 3) {
//            if (list.contains(integers)) {
//                return;
//            }
//            list.add(new LinkedList<>(integers));
//            return;
//        }
//
//        for (int i = index+1; i < len; i++) {
//            integers.add(nums[i]);
//            int nextNum = num + nums[i];
//            dfs(i, len, nextNum, nums, count + 1, list, integers);
//            integers.removeLast();
//        }
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);

        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int second = first + 1;
            int third = len - 1;
            while (second < third) {
                if (second > first+1 && nums[second] == nums[second-1]) {
                    second++;
                    continue;
                }
                if (third < len - 1 && nums[third] == nums[third+1]) {
                    third--;
                    continue;
                }
                int curNum = nums[second] + nums[third];
                if (curNum > target) {
                    third--;
                } else if (curNum < target) {
                    second++;
                } else {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    list.add(tmp);
                    second++;
                    third--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }


}
