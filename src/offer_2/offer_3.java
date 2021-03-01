package offer_2;

import java.util.HashSet;

public class offer_3 {
    /*
    * 找出数组中重复的数字。
    * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    * 请找出数组中任意一个重复的数字。
    * 快手面试题
*/
    public int findRepeatNumber_1(int[] nums) {
        if (nums == null) return -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
    // LeetCode 思路
    public int findRepeatNumber(int[] nums) {
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) { // 判断元素和下标是否相等
                if (nums[i] == nums[nums[i]]) return nums[i]; // 判断是否重复数字
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
