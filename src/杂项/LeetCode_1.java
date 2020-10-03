package 杂项;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_1 {
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
//                return new int[]{i, map.get(target - nums[i])};
//            }
//        }
//        return null;
//    }

//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                return new int[]{map.get(target - nums[i]), i};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[]{0, 0};
        HashSet<Integer> set = new HashSet<>();
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
