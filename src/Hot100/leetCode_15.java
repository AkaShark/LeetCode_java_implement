package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_15 {

    // 暴力法 代价太大 还要进行一步去重操作
    public List<List<Integer>> threeSum_1(int[] nums) {
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }

    // 排序 + 双指针 (双指针使用的 不明显) 排序时间复杂度是o(NlogN) 双指针的时间复杂度是o(N2) 最终的时间复杂度是O(n2)
    public List<List<Integer>> threeSum_2(int[] nums) {
       int n = nums.length;
       Arrays.sort(nums); // 排序
       List<List<Integer>> ans = new ArrayList<>(); // 结果list
        // 枚举a b c 固定a 枚举bc 使用双指针 因为是有序的可以根据大小移动指针
       // 枚举a
        for (int first = 0; first < n; first++) {
            // 和上一次枚举的数不同
            if (first > 0 && nums[first] == nums[first - 1]) continue; // 避免重复
            // c 指针一直指向数组的最后一个元素
            int third = n - 1;
            int target = -nums[first]; // 标记位
            // 枚举b
            for (int second = first + 1; second < n; second++) {
                // 排除相同的元素
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                // 移动第三个指针
                while (second < third && nums[third] + nums[second] > target) third --; // num[first] + nums[second] + nums[third]  > 0 因为数组的有序的大于0的话让第三个指针向后移动

                // 判读是否重合
                if (second == third) break;
                // 满足要求添加到ans 中
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;

    }

    // 排序 + 标准双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0  && nums[k] == nums[k - 1]) continue; // 跳过重复的元素
            // 设置i j 指针 在(k, len(nums))
            int i = k + 1, j = nums.length - 1;
            while (j > i) {
                int s = nums[k] + nums[i] + nums[j];
                if (s > 0) { // 大于0
                    while (j > i && nums[j] == nums[--j]); // 跳过重复的元素
                } else if (s < 0) {
                    while (j > i && nums[i] == nums[++i]); // 跳过重复的元素
                } else { // 添加到ans
                    ans.add(new ArrayList<>(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[k]
                    )));
                    // 跳过重复的元素
                    while (j > i && nums[j] == nums[--j]);
                    while (j > i && nums[i] == nums[++i]);
                }
            }
        }
        return ans;
    }

}
