package nums;

public class findDuplicate {
    /*给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

    假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

             

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/find-the-duplicate-number
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    /*//哈希
    class Solution {
        public int findDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int res = 0;
            for (int num : nums) {
                if (set.contains(num)){
                    res = num;
                    break;
                }
                set.add(num);
            }
            return res;
        }
    }*/

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len -1;
        while(left < right) {
            int mid = (left + right) >>> 1;

            int cnt = 0;//统计小于中间数的个数

            for (int num : nums) {
                if (num <= mid){
                    cnt ++;
                }
            }

            if (cnt > mid) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
