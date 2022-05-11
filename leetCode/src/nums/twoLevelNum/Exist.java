package nums.twoLevelNum;
/*https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/*/
public class Exist {
    public static boolean exist(char[][] board, String word) {
        boolean res = false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res = isOk(board, i, j, word, 0, flag);
                    if (res == true) {
                        return res;
                    }
                }
            }
        }
        return res;
    }

    private static boolean isOk(char[][] board, int row, int col, String word, int wordIndex, boolean[][] flag) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ) {
            return false;
        }
        boolean res = false;

        if (!flag[row][col] && board[row][col] == word.charAt(wordIndex)) {
            if (wordIndex == word.length() - 1) {
                res = true;
            } else {
                flag[row][col] = true;
                res = isOk(board, row - 1, col, word, wordIndex + 1, flag)
                        || isOk(board, row + 1, col, word, wordIndex + 1, flag)
                        || isOk(board, row, col - 1, word, wordIndex + 1, flag)
                        || isOk(board, row, col + 1, word, wordIndex + 1, flag);
                flag[row][col] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //String word = "ABCCED";
        char[][] board = new char[][]{{'a'}};
        String word = "ab";
        System.out.println(exist(board,word));

    }
}
