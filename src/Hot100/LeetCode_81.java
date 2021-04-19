package Hot100;

import java.util.Arrays;

public class LeetCode_81 {
    //O(n)
    public boolean search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return true;
        }
        return false;
    }

    //O(nlogn)
    public boolean search_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) {
            return true;
        } else {
            return false;
        }
    }

    // LeetCode
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return nums[0] == target ? true : false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // case
            if (nums[mid] == target) return true;
            if (nums[left] == nums[right] && nums[left] == nums[mid]) {
                ++left;
                --right;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    // LeetCode_discuss
    public boolean search_d(int[] nums, int target) {
        int i = 0, j = nums.length - 1, m = (i+j)/2;
        while(i <= j){
            if (nums[m] == target || nums[i] == target || nums[j] == target) {return true;}
            else if(nums[m] > target && nums[i] < target) {j = m - 1;}//左侧有序区间，启动二分查找
            else if(nums[m] < target && nums[j] > target) {i = m + 1;}//右侧有序区间，启动二分查找
            else {i++; j--;}//仍在中间无序部分，左边界加1，右边界减一
            m = (i + j) / 2;
        }
        return false;
    }
}
