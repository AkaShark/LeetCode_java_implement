package Hot100;

import java.util.List;

public class LeetCode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < n; row++) {
            // 只能从最左边进来的
            dp[row][0] = dp[row - 1][0] + triangle.get(row).get(0);
            // 第i行 列数为i + 1
            for (int col = 1; col < row ; col++) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row - 1][col - 1]) + triangle.get(row).get(col);
            }
            // 只能从右边进来的
            dp[row][row] = dp[row - 1][row - 1] + triangle.get(row).get(row);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }
}
