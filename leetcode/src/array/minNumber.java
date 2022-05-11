package array;

import java.util.Arrays;

public class minNumber {
    public String minNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        String[] sts = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            sts[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sts,(x, y)->(x+y).compareTo(y+x));
        for(String s:sts){
            sb.append(s);
        }
        return sb.toString();
    }
}
