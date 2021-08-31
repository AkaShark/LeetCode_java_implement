package Hot100;

public class LeetCode53_1 {
    public int search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) ans++;
        }
        return ans;
    }


    public int search_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (right > left) {
            if (nums[left] != target) left ++;
            else break;
        }
        while (right > left) {
            if (nums[right] != target) right --;
            else break;
        }
        return right - left + 1;
    }

    public int search(int[] nums, int target) {
        int leftIdx = bisection(nums, target, true);
        int rightIdx = bisection(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int bisection(int[] nums, int target, boolean lower) {
        int ans = nums.length, left = 0, right = nums.length - 1;
        while (right >= left) {
            int middle = (left + right) / 2;
            if (nums[middle] > target || (lower && nums[middle] >= target)) {
                right = middle - 1;
                ans = middle;
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }

}
