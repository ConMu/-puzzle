package elsething;

import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int bond = target/2 + 1;
        for(int l = 1,r = 2;l <bond; ) {
            int sum = (l + r) * (r - l + 1)/2;
            if(sum == target){
                int[] res = new int[r-l+1];
                for(int i = 0;i < res.length; i++) {
                    res[i] = l + i;
                }
                list.add(res);
                l++;
            }
            if(sum < target)r++;
            if(sum > target)l++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
