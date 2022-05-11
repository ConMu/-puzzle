package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuaWei771 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tw = new int[n][2];
        for (int i = 0; i < n; i++) {
            tw[i][0] = sc.nextInt();
            tw[i][1] = sc.nextInt();
        }
        System.out.println(getMaxNum(tw));
    }

    private static int getMaxNum(int[][] tw) {
        int res = 0;
        Arrays.sort(tw, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1]-o1[1]:o2[0]-o1[0];
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int index = tw[0][0];
        for (int i = 0; i < tw.length; i++) {
            if (index == 0) {
                break;
            }
            index = Math.min(index, tw[i][0]);
            if (index < tw[i][0]) {
                queue.add(new int[]{tw[i][0], tw[i][1]});
                continue;
            }
            queue.add(new int[]{tw[i][0], tw[i][1]});
            if (!queue.isEmpty()) {
                res += queue.poll()[1];
                index--;
            }
        }
        return res;
    }
}

/*
华为的机试题0707-1：
贪心做法
题目： 有n个事件，每个事件形式为(t,w),表示若在t时刻前完成该事件，获得w分数，每一个小时只能完成一个事件，求最大能获得的分数
事件数量<=1000000
输入：
7
1 6
1 7
3 2
3 1
2 8
2 10
6 1
输出：21
*/
