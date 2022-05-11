package tu;

public class FindCircleNum {
    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i ; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(i, j, parent);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < len; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;

    }
    private void dfs(boolean[] visited, int n, int[][] isConnected) {
        int len = isConnected.length;
        for (int i = 0; i < len; i++) {
            if (isConnected[n][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(visited, i, isConnected);
            }
        }
    }

    private static void union(int i, int j, int[] parent) {
        parent[find(parent, i)] = find(parent, j);
    }

    private static int find(int[] parent, int j) {
        if (parent[j] != j) {
            parent[j] = find(parent, parent[j]);
        }
        return parent[j];
    }


    public int findCircleNum2(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(visited, i, isConnected);
                num++;
            }
        }
        return num;
    }



    public static void main(String[] args) {
        int[][] os = new int[][]{{1, 0, 0,1}, {0,1, 1, 0}, {0, 1, 1,1},{1,0,1,1}};
        System.out.println(findCircleNum(os));

    }
}
