package 数组.简单;

import java.util.HashMap;

public class _1_两数之和 {
    //    利用hashmap一边遍历 HashMap中存nums[i] 和 i
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int temp  = target-nums[i];
//            if (map.containsKey(temp)){
//                return new int[]{map.get(temp),i};
//            }
//            map.put(nums[i],i);
//        }
//        return null;
//    }

    //    循环遍历 判断相加的和
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//    j = i+1 这样的话 保证了题目中的不重复使用
//            for (int j = i+1; j <nums.length ; j++) {
//                if (nums[i]+nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return null;
//    }
//    减少时间复杂度用空间换时间
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < map.size(); i++) {
            int complement = target - nums[i];
//            保证不用重复的元素
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }

}

