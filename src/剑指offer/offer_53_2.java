package 剑指offer;

public class offer_53_2 {
    /*
    * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
    * 并且每个数字都在范围0～n-1之内。
    * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
*/
    // 递增 唯一 暴力破解
    public int missingNumber_1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        // 少了最后一个数
        return nums.length;
    }
    // 有序 二分实现
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            int mid = (end + start) >> 1;
            // 二分策略修改之分为等于和不等于
            if (nums[mid] == mid) start = mid + 1;
            else end = mid - 1;
        }
        // start 指向了右子数组的首个元素 这个index就是缺失的数
        return start;
    }

}
