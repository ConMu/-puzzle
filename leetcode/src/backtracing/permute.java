package backtracing;

import java.util.*;

public class permute {
    /*
    * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    *
    * */
    class Solution {
        /*
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null){
                return res;
            }
            Deque<Integer> path = new ArrayDeque<Integer>();
            boolean[] used = new boolean[len];
            bfs(nums,len,0,path,used,res);
            return res;

        }

        private void bfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
            if (depth == len ){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (used[i]){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                bfs(nums,len,depth+1,path,used,res);
                path.removeLast();
                used[i] = false;
            }

        }
        */

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            if (nums == null) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<Integer>();
            boolean[] used = new boolean[len];
            dfs(nums,len,0,path,used,res);
            return res;

        }

        private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
            if (depth == len){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (used[i]){
                    continue;
                }
                path.addLast(nums[i]);
                used[i] =true;
                dfs(nums,len,depth + 1,path,used,res);
                path.removeLast();
                used[i] = false;
            }
        }

    }

}
