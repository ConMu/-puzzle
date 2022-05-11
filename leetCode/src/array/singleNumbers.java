package array;

public class singleNumbers {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[]{0, 0};
        for (int num : nums) {
            res[0] ^= num;
        }
        int right = res[0] & (-res[0]);
        for (int num : nums) {
            if ((num & right) == 0) res[1] ^= num;
        }
        res[0] = res[0] ^ res[1];
        return res;
    }
}
