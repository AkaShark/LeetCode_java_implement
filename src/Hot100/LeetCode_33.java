package Hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_33 {
    // 时间复杂度O(n2) 过了 而且效率挺高？？？
    public int search_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    // 还原成原数组 二分查找  空间复杂度O(n) 时间复杂度O(NlogN) fail
    public int search_2(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) continue;
            else index = i;
        }

        List<Integer> numList = new ArrayList<>();

        for (int i = index; i < nums.length; i++) {
            numList.add(nums[i]);
        }

        for (int i = 0; i < index; i++) {
            numList.add(nums[i]);
        }

        int res = 0;
        int left = 0, right = numList.size();
        while (right > left) {
            int mid = left+(right-left)/2;
            if (numList.get(mid) > target) {
                right = mid;
            } else if (numList.get(mid) < target){
                left = mid - 1;
            } else {
                res = mid;
            }
        }
        // res 是原数组的找到的index 但是需要的是旋转后的数组的index这个地方怎么处理呢
        // 还原原数组不是个好主意

        return -1;
    }

    // 不还原原数组直接对于两个部分开始二分查找 时间原因没调 但是感觉应该是OK的
    public int search_3(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) continue;
            else index = i + 1;
        }
        if (target > nums[index] && target < nums[nums.length - 1]) {
            // 后半部分找
            return binaryFind(nums, index, nums.length, target);

        } else if (target > nums[0] && target < nums[index - 1]) {
            // 前半部分
            return binaryFind(nums, 0, index - 1, target);
        } else return -1;

    }

    public int binaryFind(int[] nums, int left, int right, int target) {
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else  {
                return mid;
            }
        }
        return -1;
    }



    // leetCode 答案 O(LogN)
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0: -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边是有序的
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1; // 上前半部分中找去
                } else {
                    l = mid + 1;
                }
            } else { // 右边有序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }












    }
