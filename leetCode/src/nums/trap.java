package nums;

public class trap {

 /*   给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
    计算按此排列的柱子，下雨之后能接多少雨水。*/

    public static int trap(int[] height) {
        /*//超时
        int maxValue = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            maxValue = maxValue > height[i] ? maxValue:height[i];
        }
        int res = 0;
        for (int i = 1; i <= maxValue ; i++) {
            int left = 0,right = len - 1;
            while(height[left] < i) {
                left ++;
            }
            while(height[right] < i) {
                right --;
            }
            for (int j = 0; j < len; j++) {
                if (height[j] < i && j > left && j< right) {
                    res++;
                }
            }
        }
        return res;*/

        int sum = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        for (int i = 1; i < len - 1; i++) {
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
        }
        for (int i = len -2; i >=0 ; i--) {
            max_right[i] = Math.max(max_right[i + 1],height[i+1]);
        }
        for (int i = 1; i < len -1; i++) {
            if (height[i] < max_left[i] && height[i] <max_right[i]) {
                sum += Math.min(max_left[i],max_right[i]) -height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,0,3,2,5};
        System.out.println(trap(test));
    }
}

