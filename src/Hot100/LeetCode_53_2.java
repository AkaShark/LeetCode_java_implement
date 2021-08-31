package Hot100;

public class LeetCode_53_2 {
    public int missingNumber_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 0) {
            if (nums[0] == 0) return 1;
            if (nums[0] == 1) return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) != 1) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (middle == nums[middle]) { // 左边排除
                left = middle + 1;
            } else { // 右边排除
                right = middle;
            }
        }
        return left;
    }
}
