package 剑指offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class offer_61 {
    // 判断下是否每个元素之前相差1 排序加遍历
    public boolean isStraight_1(int[] nums) {
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

    public boolean isStraight_2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num: nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) return false; // 有重复的元素直接返回false
            repeat.add(num); // 添加到set中
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可以构成顺子
    }

    // leetCode 版本排序加遍历
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可以构成顺子
    }
}
