package Hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_34 {
    // 时间复杂度
    public int[] searchRange_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 等于 但是不符合时间复杂度 线性的查找了下
                int start = mid, end = mid;
                while (start >=0) {
                    if (nums[start] != target) {
                        start ++;
                        break;
                    } else start --;
                }
                while (end < nums.length) {
                    if (nums[end] != target) {
                        end --;
                        break;
                    } else end ++;
                }
                if(start <= 0) start = 0;
                if(end >= nums.length) end = nums.length - 1;

                res[0] = start;
                res[1] = end;
                return res;
            }
        }
        return res;

    }

    // 二分法改进
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return new int[]{-1, -1};
        // 目标值的开始位置 mid分到右边的情况 第一个大于等于mid
        // 目标值的结束位置 mid分到左边的情况 最后一个小于等于mid

        int start = 0, end = 0;
        int left = 0, right = nums.length - 1;
        // mid分到右边
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        start = left;

        // mid分到左边
        int left_1 = 0, right_1 = nums.length - 1;
        while (left_1 < right_1) {
            int middle = left_1 + (right_1 - left_1 + 1) / 2;
            if (nums[middle] > target) {
                right_1 = middle - 1;
            } else {
                left_1 = middle;
            }
        }
        end = left_1;

        if (nums[start] != target) start = -1;
        if (nums[end] != target) end = -1;

        return new int[]{start, end};
    }
}
