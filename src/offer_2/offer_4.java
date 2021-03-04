package offer_2;

public class offer_4 {
    // 遍历暴力法
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray_2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // 找到元素存在的哪一行
        for (int i = 0; i < matrix.length; i++) {
            // 大于开始 小于结尾
            if (matrix[i][0] <= target && target <= matrix[i][matrix[0].length - 1]) {
                // 从这一行开始找
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
        }
        return false;
    }

    // 因为每行每列都是递增的 所有从左下角的元素或者右上角的元素入手
    public boolean findNumberIn2DArray_3(int[][] matrix, int target) {
        // 左下角
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) { // 这一行不用考虑了
                i --;
            } else if (matrix[i][j] < target) { // 这一列不考虑了
                j ++ ;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // 右上角
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) { // 这一列不用考虑了
                j --;
            } else if (matrix[i][j] < target) { // 这一行不用考虑了
                i ++;
            } else {
                return true;
            }
        }
        return false;

    }






}
