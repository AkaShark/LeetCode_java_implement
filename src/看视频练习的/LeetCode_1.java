package 看视频练习的;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_1 {

    // 暴力
    public int[] twoSum(int[] nums, int target) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // HashMap 两次遍历
    public int[] twoSum_1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            // 防止是重复的元素
            if (map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{i, map.get(temp)};
            }
        }
        return null;
    }

    // HashMap 一次遍历
    public int[] twoSum_2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 这个i 直接就加了 所以不存在重复元素的情况
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // HashSet
    public int[] twoSum_3(int[] nums, int target) {
        int[] index = new int[]{0,1};
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(target - nums[i])) { // 检查是否有nums[i]匹配的元素存在 没有则添加成功
                set.remove(target-nums[i]);
                set.add(nums[i]);

            } else {
                index[1] = i;
                for (int j = 0; j < i; j++) {
                    if (target == (nums[i]+nums[j])) {
                        index[0] = j+1;
                        return index;
                    }
                }
            }
        }
        return null;
    }

    /// HashSet
    public int[] twoSum_4(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] index = new int[]{0, 1};
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(target - nums[i])) {
                set.add(nums[i]);
            } else {
                index[1] = i;
                for (int j = 0; j < i; j++) {
                    if (nums[j] == target - nums[i]) {
                        index[0] = j;
                        return index;
                    }
                }
            }
        }
        return null;
    }



}
