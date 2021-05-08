package Hot100;

public class LeetCode_154 {
    public int findMin_1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left ++;
                right --;
                continue;
            }
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    // 不行废物方法
    public int findMin_2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        if (left < right) {
            int mid = left + (right - left) / 2;
            int min = Math.min(nums[left], nums[right]);
            res = Math.min(min, res);
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
            int min1 = Math.min(nums[left], nums[right]);
            res = Math.min(min1, res);

            if (nums[mid] < res) {
                res = nums[mid];
            }
        }
        return res;
    }

    // LeetCode
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) { // 右边有序 遗弃
                right = mid;
            } else if (nums[mid] == nums[right]) { // 相等的话 无法遗弃一般 但是可以遗弃right
                right --;
            } else {  // 左边有序 遗弃 可以加1的原因是mid > right so 一定不是最小值
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
