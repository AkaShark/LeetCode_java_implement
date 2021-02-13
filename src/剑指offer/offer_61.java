package 剑指offer;

import java.util.Arrays;

public class offer_61 {
    // 判断下是否每个元素之前相差1
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length < 5) return false;
        int king = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                king ++;
                continue;
            }
            if (nums[i + 1] - nums[i] == 0) return false;
            if (nums[i + 1] - nums[i] != 1) {
                if (king == nums[i + 1] - nums[i] - 1) {
                    continue;
                }
                return false;
            }

        }
        return true;
    }
}
