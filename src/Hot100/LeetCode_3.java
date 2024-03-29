package Hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_3 {
    public int findRepeatNumber_1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return nums[i];
        }
        return -1;
    }

    public int findRepeatNumber_2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    // 原地交换
    public int findRepeatNumber(int[] nums) {
       int i = 0;
       while (i < nums.length) {
           if (nums[i] == i) {
               i++;
               continue;
           }
           if (nums[nums[i]] == nums[i]) return nums[i];
           int temp = nums[i];
           nums[i] = nums[temp];
           nums[temp] = temp;
       }
       return -1;
    }
}
