package BinarySearch;

public class LeetCode_704 {
    public int search_1(int[] nums, int target) {
        if (nums == null && nums.length <= 0) return -1;
        int left = 0, right = nums.length - 1;
        while (right >= left) { // 这里是大于等于 如果只有一个元素的话直接就跳过这个块了
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) { // [mid + 1, right]
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    // 二分改进
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) { // mid+1 .. right
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ?left: -1;
    }

}
