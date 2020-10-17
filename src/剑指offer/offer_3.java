package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class offer_3 {

    // 书上给的解答方法 但是leetcode超时了。。。。wcnd
    public int findRepeatNumber_1(int[] nums) {
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
}
