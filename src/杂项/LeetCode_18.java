package 杂项;

import java.lang.reflect.Array;
import java.util.*;

public class LeetCode_18 {
    // 固定两个数 另外的采用双指针法进行查找
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }
        res = new ArrayList<>(new HashSet<>(res));
        return res;
    }


    // LeetCode 时间复杂度优化很多 省去了去重的操作 直接在添加的时候就加上了去重的操作
    public List<List<Integer>> fourSum_1(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        // 不存在
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {
            // 去重的操作 优化
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            if (nums[i] + nums[length-3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j+1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return quadruplets;

    }
}
