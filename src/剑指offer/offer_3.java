package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class offer_3 {

    // 书上给的解答方法 但是leetcode超时了。。。。wcnd
    // 异常
//        if (nums == null || nums.length <= 0) {
//            return 0;
//        }
//        // 判断异常nums中的数字都是在0-n-1中 这个没必要了
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < 0 || nums[i] > nums.length - 1) {
//                return 0;
//            }
//        }

    public int findRepeatNumber_1(int[] nums) {
        // 循环
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                // Swap
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return 0;
    }

    // LeetCode 原地置换算法 这个就是可以的 唯一的区别就是不用 nums[nums[i]] 可是数组的按照下标的访问不是瞬间的么。。。。
    public int findRepeatNumber_0(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }


    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;

    }


    public int findRepeatNumber_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repet = -1;
        for (int item : nums) {
            if (!set.add(item)) {
                repet = item;
                break;
            }
        }
        return repet;
    }


    public int findRepeatNumber_3(int[] nums) {
        // 异常处理
        if (nums == null || nums.length < 0) return -1;
        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, nums.length, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null) return 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;

    }
}
