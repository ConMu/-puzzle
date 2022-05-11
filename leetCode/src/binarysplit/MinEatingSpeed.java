package binarysplit;

import java.util.Arrays;

/*https://leetcode-cn.com/problems/koko-eating-bananas/description/*/
public class MinEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length;
        boolean flag = true;
        int maxSpeed = piles[len - 1];
        int minSpeed = 1;
        int midSpeed = (maxSpeed + minSpeed) / 2;
        int countHour = 0;
        //ans = 4
        while (maxSpeed >= minSpeed) {
            midSpeed = (maxSpeed + minSpeed) / 2;
            if (getCount(midSpeed, piles,h)) {
                maxSpeed = midSpeed - 1;
            } else {
                minSpeed = midSpeed + 1;
            }
        }
        return midSpeed;
    }

    private static boolean getCount(int midSpeed, int[] piles, int h) {
        int res = 0;
        for (int pile : piles) {
            res += Math.ceil((double)pile/midSpeed);
        }
        return res >= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
        System.out.println(3/2);

    }


}
