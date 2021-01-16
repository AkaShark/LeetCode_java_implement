package 剑指offer;

public class offer_42 {
    // 暴力法解决 n3 时间复杂度过不去
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // 计算i到j的和
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                }
                if (sum > max) max = sum;
            }
        }
        return max;
    }
}
