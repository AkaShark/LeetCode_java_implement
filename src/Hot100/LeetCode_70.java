package Hot100;

public class LeetCode_70 {
    public int climbStairs_1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (n == 0 || n == 1) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        int ans = 1, dp0 = 1, dp1 = 1;
        if (n == 0 || n == 1) return ans;
        for (int i = 2; i <= n; i++) {
            ans = dp0 + dp1;
            dp0 = dp1;
            dp1 = ans;
        }
        return ans;
    }
}
