package 剑指offer;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedList;
import java.util.List;

public class offer_47 {
    // 给定网格 确定可以拿到最大的礼物的价值数
    // 回溯
    //
//    public int maxValue(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) return -1;
//        Boolean[][] vieited = new Boolean[][]{};
//        int sum = sourceGrid(grid, vieited, 0, grid.length, 0, grid[0].length);
//        return sum;
//    }
//
//    public int sourceGrid(int[][] grid, Boolean[][] visited, int row, int rows, int col, int cols) {
//        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) return 0;
//        visited[row][col] = true;
//        return  sourceGrid(grid, visited, row + 1, rows, col, cols) +
//                sourceGrid(grid, visited, row - 1, rows, col, cols) +
//                sourceGrid(grid, visited, row, rows, col + 1, cols) +
//                sourceGrid(grid, visited, row, rows, col - 1, cols);
//    }

    // 动态规划 直接使用grid数组不在创建新数组
    // 转移方程 grid[i][j] = Max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]; 再去判断一些特殊情况
    public int maxValue_1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一个元素
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j-1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
    // 优化 不用每次都判断迭代 因为直接用的gird的空间 所有可以初始化第一行第一列同时在下面的循环中可以进行简化
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) { // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0]; // 初始化第一列
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j <n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
    
    
}
