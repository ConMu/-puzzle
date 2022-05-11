package tu;

import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            nums[i][2] = sc.nextInt();
        }
        System.out.println(minLen(nums, num));
    }

    private static int minLen(int[][] nums, int num) {
        int[][] tu = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i != j) {
                    tu[i][j] = 99999999;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            tu[nums[i][0]][nums[i][1]] = nums[i][2];
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    if (tu[j][k] > (tu[j][i] + tu[i][k])) {
                        tu[j][k] = tu[j][i] + tu[i][k];
                    }
                }
            }
        }
        return tu[0][num - 1];
    }


}
