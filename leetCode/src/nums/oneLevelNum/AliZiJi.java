package nums.oneLevelNum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AliZiJi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                nums[j][0] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                nums[j][1] = sc.nextInt();
            }
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    //递增
                    return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0]-o2[0];
                }
            });
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = nums[j][1];
            }
            System.out.println(getMaxNum(tmp));
        }
    }

    private static int getMaxNum(int[] nums) {
        //tails[k] 的值代表长度为k+1子序列 的尾部元素值
        int[] tails = new int[nums.length];
        // res 为 tails当前长度
        int res = 0;
        for (int num:nums)
        {
            int l = 0;
            //r为数组的长度，而不是length-1，这点要注意
            int r = res;
            while(l < r)
            {
                int m = l + (r - l)/2;
                if(tails[m] < num)
                    l = m + 1;
                else
                    r = m;
            }
            tails[l] = num;
            if(r == res)
                res++;
        }
        return  res;

    }
}
