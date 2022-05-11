package tu;

import java.util.Scanner;

public class HuaWei772 {
    static boolean[] visited;
    static int[][] tmp;
    static int maxPath = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] nums = new int[100][3];
        int index = 0;
        int num = 0;
        int start = 0;
        boolean flag = true;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.charAt(0) == '[') {
                s = s.substring(1, s.length() - 1);
                String[] split = s.split(",");
                nums[index][0] = Integer.parseInt(split[0]);
                nums[index][1] = Integer.parseInt(split[1]);
                nums[index][2] = Integer.parseInt(split[2]);
                index++;
            } else if (flag) {
                num = Integer.parseInt(s);
                flag = false;
            } else {
                start = Integer.parseInt(s);
                break;
            }
        }
        tmp = new int[num+1][num+1];
        for (int i = 0; i < num+1; i++) {
            tmp[nums[i][0]][nums[i][1]] = nums[i][2];
        }
        visited = new boolean[num + 1];
        dfs(start, num, 0);
        boolean twoFlag = false;
        for (int i = 1; i < num; i++) {
            if (!visited[i]) {
                twoFlag = true;
                break;
            }
        }
        if (twoFlag) {
            System.out.println(0);
        } else {
            System.out.println(maxPath);
        }


//        String s = "[1,2,3]";
//        String substring = s.substring(1, s.length() - 2);


//        System.out.println(minLen(nums));
    }

    private static void dfs(int start, int num, int path) {
        visited[num] = true;
        for (int i = 0; i < num; i++) {
            if (tmp[start][i] > 0 && !visited[i]) {
                path += tmp[start][i];
                dfs(i, num, path);
                maxPath = Math.max(maxPath, path);
                path -= tmp[start][i];
            }
        }
    }


//    private static int minLen(int[][] nums) {
//
//        int[][] tu = new int[num][num];
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num; j++) {
//                if (i != j) {
//                    tu[i][j] = 99999999;
//                }
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            tu[nums[i][0]][nums[i][1]] = nums[i][2];
//        }
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num; j++) {
//                for (int k = 0; k < num; k++) {
//                    if (tu[j][k] > (tu[j][i] + tu[i][k])) {
//                        tu[j][k] = tu[j][i] + tu[i][k];
//                    }
//                }
//            }
//        }
//        return tu[0][num - 1];
//    }
}
