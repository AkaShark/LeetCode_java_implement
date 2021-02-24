package Hot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class leetCode_1 {
    /*
    给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    你可以按任意顺序返回答案。
*/
    // 排序 双指针 我觉得肯定可以再想想 实现下 还是有点问题
    public int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            array.add(nums[i]);
        }
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        while (end > start) {
            if (nums[start] + nums[end] > target) end --;
            else if (nums[start] + nums[end] < target) start ++;
            else { // 等于target
               // 原元素组已经排序改变了 不能直接返回start end 需要找到对应的start和end的位置
                int[] res = new int[2];
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i) == nums[start]) res[0] = i;
                    else if (array.get(i) == nums[end]) res[1] = i;
                }
                if (res[0] > res[1]) {
                   int temp = res[0];
                   res[0] = res[1];
                   res[1] = temp;
                }

                return res;
            }
        }
        return new int[0];
    }

    // 双循环
    public int[] twoSum_2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }

    // Map
    public int[] twoSum_3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // 二分法实现
    public int[] twoSum(int[] nums, int target) {

    }

}
