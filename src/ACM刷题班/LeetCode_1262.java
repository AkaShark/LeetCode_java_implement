package ACM刷题班;

public class LeetCode_1262 {
    // O(n)暴力方法
    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ret = maxSumDivThree(nums, 3);
        return ret;
    }

    public int maxSumDivThree(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n+1][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = 0;
        }
        boolean[] flag = new boolean[k];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < k; j++) {
                int sum = dp[i][j] + num;
                int ii = sum % k;
                flag[ii] = true;
                dp[i+1][ii] = Math.max(sum, Math.max(dp[i+1][ii],dp[i][ii]));
            }
            for (int j = 0; j < k; j++) {
                if (flag[j]) flag[j] = false;
                else dp[i+1][j] = dp[i][j];
            }
        }
        return dp[n][0];
    }
}
