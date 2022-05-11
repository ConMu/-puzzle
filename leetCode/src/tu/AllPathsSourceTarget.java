package tu;

import java.util.*;

public class AllPathsSourceTarget {
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < graph.length; i++) {
            for (int nums : graph[i]) {
                flag[i][nums] = true;
            }
        }
        dfs(0, n - 1, flag, new LinkedList<Integer>());
        return res;
    }

    private static void dfs(int curIndex, int aim, boolean[][] flag, LinkedList<Integer> list) {
        list.add(curIndex);
        if (curIndex == aim) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < flag[0].length; i++) {
            if (flag[curIndex][i]) {
                dfs(i, aim, flag, list);
                list.removeLast();
            }
        }
    }
    static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        stack.offerLast(0);
        dfs2(graph, 0, graph.length - 1);
        return res;
    }

    public static void dfs2(int[][] graph, int x, int n) {
        if (x == n) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs2(graph, y, n);
            stack.pollLast();
        }
    }

    public static void main(String[] args) {
        int[][] tmp = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        allPathsSourceTarget(tmp);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
