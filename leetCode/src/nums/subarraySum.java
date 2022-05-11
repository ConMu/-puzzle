package nums;

import java.util.HashMap;

public class subarraySum {
    /*给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数*/
    //暴力求解 ，定义双指针 i j
    /*public int subarraySum(int[] nums, int k) {
        int res = 0;

        for (int i = nums.length-1; i >= 0; i--) {
            int tmp = 0;
            for (int j = i; j >=0 ; j--) {
                tmp += nums[j];
                if (tmp == k){
                    res ++;
                }
            }
        }
        return res;
    }*/
    //前缀和求法
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int tmp = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (map.containsKey(tmp - k)) {
                res += map.get(tmp - k);
            }
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test= new int[]{1,1,1};
        int k = 2;
        subarraySum(test,k);
    }

}
