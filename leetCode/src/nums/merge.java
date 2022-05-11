package nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge {
   /* 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-intervals
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
   public int[][] merge(int[][] intervals) {
       if (intervals.length==0) {
           return new int[0][0];
       }
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0] - o2[0];
           }
       });
       List<int[]> res = new ArrayList<>();
       for (int i = 0; i <intervals.length ; i++) {
           int L = intervals[i][0],R = intervals[i][1];
           if (res.size() == 0 || L > res.get(res.size()-1)[1]) {
               res.add(intervals[i]);
           }else {
               res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],R);
           }
       }
       return res.toArray(new int[res.size()-1][]);
   }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] test = new int[]{0,1,2,3};
        for (int i = 0; i < test.length; i++) {
            list.add(test[i]);
        }
        list.toArray();
        System.out.println(list);

    }

}
