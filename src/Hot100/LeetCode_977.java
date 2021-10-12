package Hot100;

public class LeetCode_977 {
    // 绝对值 交换位置
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1, pos = nums.length - 1;
        while (right >= left) {
            if (nums[left] >= nums[right]) {
                ans[pos] = nums[left] * nums[left];
                left ++;
            } else {
                ans[pos] = nums[right] * nums[right];
                right --;
            }
            pos --;
        }
        return ans;
    }
}
