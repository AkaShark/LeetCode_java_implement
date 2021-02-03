package 剑指offer;

public class offer_57 {
    /*输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可*/
    // 暴力破解 时间复杂度不过
    public int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    // 有序 双指针
    public int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            if (nums[end] + nums[start] == target) {
                return new int[]{nums[start], nums[end]};
            } else if (nums[end] + nums[start] < target) {
                start ++;
            } else {
                end --;
            }
        }
        return new int[0];
    }

    // 二分法
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end) >> 1;
            if (nums[mid] + nums[start] == target) {
                return new int[]{nums[start], nums[mid]};
            } else if (nums[mid] + nums[start] > target) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return new int[0];
    }
}
