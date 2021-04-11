package Hot100;

public class LeetCode_35 {
    // 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) { // 一定不符合的情况
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

