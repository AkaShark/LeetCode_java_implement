package 剑指offer;

public class offer_53 {
    // 统计一个数字在排序数组中出现的次数。
    // 暴力 时间复杂度O(n)
    public int search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) res++;
        }
        return res;
    }

    // 查找 有序 二分处理
    public int search_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0, start = 0, end = nums.length - 1, middle = 0;
        while (end >= start) {
            middle = (start + end) >> 1;
            if (nums[middle] == target) {
                res ++;
                break;
            }
            else if (nums[middle] < target){
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        start = middle - 1;
        end = middle + 1;
        while (start >= 0 && start < nums.length) {
            if (nums[start] == target) {
                res ++;
                start --;
            } else
                break;
        }

        while (end < nums.length) {
            if (nums[end] == target) {
                res ++;
                end ++;
            } else
                break;
        }
        return res;
    }

    // LeetCode 代码 两次二分法
    public int search_3(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i; // 右边界 i 是在m等于的时候 - 1
        // 若数组中没有target 直接返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索做边界 right
        i = 0; j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else  j = m - 1;
        }
        int left = j; // 找左边界 j 是在m等与的时候 + 1
        return right - left - 1;
    }

    // 由于数组 numsnums 中元素都为整数，因此可以分别二分查找 targettarget 和 target - 1target−1 的右边界，将两结果相减并返回即可。
    // helper() 函数旨在查找数字 tartar 在数组 numsnums 中的 插入点 ，且若数组中存在值相同的元素，则插入到这些元素的右边。

    // 相当于 找了当前tar的右边距 同时找了tar-1的右边距 相减的话就是中间tar的长度即个数
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i; // 返回right
    }
}
