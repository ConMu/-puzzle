package elsething;

public class spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length, col = matrix[0].length;
        int[] order = new int[row * col];
        int index = 0;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while(left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int column = top + 1; column <= bottom ;column ++) {
                order[index++] = matrix[column][right];
            }
            //如果这个时候没有只剩一行
            if (left < right && top < bottom) {
                for (int column = right - 1; column >= left ; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int column = bottom - 1;column >= top +1;column-- ) {
                    order[index++] = matrix[column][left];
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return order;

    }
}
