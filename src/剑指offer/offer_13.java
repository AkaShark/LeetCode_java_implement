package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_13 {

    public int movingCount(int m, int n, int k) {
        // 设置已访问的数组
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);


    }
    public int dfs(int row, int col, int rows, int cols, int k, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || calculate(row, col) > k || visited[row][col]) return 0;
        visited[row][col] = true;
        return  dfs(row + 1, col, rows, cols, k, visited) +
                dfs(row - 1, col, rows, cols, k, visited) +
                dfs(row, col - 1 , rows, cols, k, visited) +
                dfs(row, col + 1, rows, cols, k, visited) + 1;
    }

    // 计算行列之和
    public int calculate(int row, int col) {
        int rowSum = 0;
        int colSum = 0;
        while (row > 0) {
            rowSum += row%10;
            row = row/10;
        }
        while (col > 0) {
            colSum += col % 10;
            col /= 10;
        }
        return rowSum + colSum;

    }
}
