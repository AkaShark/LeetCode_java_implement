package Hot100;

public class LeetCode_283 {
    public void moveZeroes_1(int[] nums) {
        int left = 0, right = left;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = i;
                right = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        right = j;
                        break;
                    }
                }
                if (left != right && nums[right] != 0) {
                    // 交换位置
                    swap(nums, left, right);
                }
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left ++; // left指向排序好的最后面
            }
            right ++;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int left = l, right = r;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

    }
}
