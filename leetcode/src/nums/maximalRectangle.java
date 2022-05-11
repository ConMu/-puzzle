package nums;

public class maximalRectangle {
    /*给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。*/

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)return 0;
        int[][] width = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //遍历得到每个位置向左看全是1的数量
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    }else{
                        width[row][col] = width[row][col - 1] + 1;
                    }
                }else {
                    width[row][col] = 0;
                }

                int minValue = width[row][col];
                //向上看，宽度为该列数量的最小值
                for (int i = row; i >= 0; i--) {
                    int high = row - i + 1;
                    minValue = Math.min(minValue,width[i][col]);
                    res = Math.max(high * minValue,res);
                }
            }
        }
        return res;
    }



}
