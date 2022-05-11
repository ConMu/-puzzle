package nums.oneLevelNum;
/*https://leetcode-cn.com/problems/container-with-most-water/*/
public class MaxArea {
    public static int maxArea(int[] height) {
//        if (height.length < 2) {
//            return 0;
//        }
//        int res = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            int tmp = 0;
//            for (int j = 0; j < height.length; j++) {
//                int area = getArea(height, i, j);
//                tmp = Math.max(area, tmp);
//            }
//            res = Math.max(res, tmp);
//        }
//        return res;
        int length = height.length;
        if (length < 2) {
            return 0;
        }
        int left = 0, right = length - 1;
        int res = 0;
        while (left < right) {
            int leftValue = height[left], rightValue = height[right];
            int tmp = (right - left) * Math.min(leftValue,rightValue);
            res = Math.max(res, tmp);
            if (leftValue > rightValue) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    private static int getArea(int[] height, int i, int j) {
        return (j - i) * Math.min(height[j],height[i]);
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(h));

    }
}
