package dfspro;

import java.util.LinkedList;
import java.util.List;
/*https://leetcode-cn.com/problems/subsets/*/
public class Subsets {

    static List<List<Integer>> res;
    public static List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new LinkedList<>());
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        res.add(list);
        for (int i = 1; i < nums.length; i++) {
            int count = res.size();
            for (int j = 0; j < count; j++) {
                List<Integer> tmp = new LinkedList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(new LinkedList<>(tmp));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        subsets(nums);
    }
}
