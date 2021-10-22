package Hot100;

public class LeetCode_198 {
    public int rob_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        if (nums.length == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return dp[1];
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int ans = 0, dp0 = nums[0], dp1 = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return dp1;
        for (int i = 2; i < nums.length; i++) {
            ans = Math.max(nums[i] + dp0, dp1);
            dp0 = dp1;
            dp1 = ans;
        }
        return ans;
    }
}
