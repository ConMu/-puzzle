package nums;

import java.util.LinkedList;
import java.util.List;

public class subsets {

    /*
    * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    *
    * */
    public List<List<Integer>> subsets(int[] nums) {
        return process(nums.length,nums);
    }
    public List<List<Integer>> process (int index,int[] nums) {
        List<List<Integer>> res = new LinkedList();
        if (index == 0) {
            res.add(new LinkedList<Integer>());
            return res;
        }
        List<List<Integer>> last = process(index -1 ,nums);
        res.addAll(last);
        for (List<Integer> integers : last) {
            LinkedList<Integer> a = new LinkedList<>(integers);
            a.add(nums[index-1]);
            res.add(a);
        }
        return res;
    }


    //位解法
    public List<List<Integer>> binaryBit (int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i <(1<<nums.length) ; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i>>j & 1) != 0) list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }


}
