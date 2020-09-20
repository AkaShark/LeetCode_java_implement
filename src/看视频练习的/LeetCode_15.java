package 看视频练习的;

import java.util.*;

public class LeetCode_15 {
    /// nums = [-1, 0, 1, 2, -1, -4]，

    // 暴力法 不尝试 时间复杂度过不去
    
    // set实现 o(n2) 没解决 问题是重复的问题
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        HashSet<Integer> set = new HashSet<>();
//        // 装到set里面
//        for (int i = 0; i <nums.length ; i++) {
//            set.add(nums[i]);
//        }
//
//        // 枚举a和b
//        for (int i = 0; i < set.size(); i++) {
//            for (int j = i+1; j < set.size(); j++) {
//                int temp = nums[i] + nums[j];
//                if (set.contains(-temp)) {
//                    List list = new ArrayList();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(-temp);
//                    set.remove(-temp);
//                    result.add(list);
//                }
//            }
//        }
//
//        return result;
//    }


    // 排序
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> ls = new ArrayList<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
//
//                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
//                while (l < r) {
//                    if (nums[l] + nums[r] == sum) {
//                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
//                        while (l < r && nums[l] == nums[l + 1]) l++;
//                        while (l < r && nums[r] == nums[r - 1]) r--;
//                        l++;
//                        r--;
//                    } else if (nums[l] + nums[r] < sum) {
//                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
//                        l++;
//                    } else {
//                        while (l < r && nums[r] == nums[r - 1]) r--;
//                        r--;
//                    }
//                }
//            }
//        }
//        return ls;
//    }

    // 双指针 + 排序解决

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举a
        for (int first = 0; first < n; first++) {
            // 需要和上次枚举的数不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始化指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second -1 ]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合 随着b后续的增加 就不会满足条件
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    // 添加结果
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;

    }
}
