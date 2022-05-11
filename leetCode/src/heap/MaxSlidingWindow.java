package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
/*https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/*/
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] != o2[0] ? o2[0]-o1[0]:o2[1]-o1[1];
            }
        });
        for ( int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i],i});
        }
        res[0] = queue.peek()[0];
        for (int j = k; j < nums.length; j++) {
            queue.add(new int[]{nums[j],j});
            while (queue.peek()[1] < j - k + 1) {
                queue.poll();
            }
            res[j-k+1] = queue.peek()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);
        for(int i : res){
            System.out.println(i);
        }

    }
}
