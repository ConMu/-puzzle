package backtracing;

import java.util.*;

public class combinationSum {
    /*
    * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    *
    * */


    class Solution {
        /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (len == 0)return res;
            Deque<Integer> path = new ArrayDeque<>();
            dfs(candidates,0,len,target,path,res);
            return res;

        }

        private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, LinkedList<List<Integer>> res) {
            if (target < 0) return;
            if (target == 0){
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                path.addLast(candidates[i]);
                dfs(candidates,i,len,target - candidates[i],path,res);
                path.removeLast();
            }
        }
        */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int len = candidates.length;
            if (candidates == null) {
                return res;
            }
            Deque<Integer> path = new ArrayDeque<Integer>();
            dfs(candidates,0,target,path,res,len);
            return res;
        }

        private void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res, int len) {
            if (target<0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                path.addLast(candidates[i]);
                dfs(candidates,i,target-candidates[i],path,res,len);
                path.removeLast();
            }
        }

    }
}



