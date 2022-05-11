package nums.oneLevelNum;
/*https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/*/
public class HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        int index = 1, bound = 32;
        while (bound > 0) {
            if ((n & index) != 0) {
                count++;
            }
            index = index << 1;
            bound--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));

    }
}
