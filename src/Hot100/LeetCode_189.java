package Hot100;
// https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
public class LeetCode_189 {
    // 使用额外空间
    public void rotate_1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
            return;
        }
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(array, 0, nums, 0,nums.length);
    }


    public void rotate_2(int[] nums, int k) {
        k %= nums.length; // k值大于数组长度 相当于翻转k-nums.length
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
    // 这个方法不太理解
    public void rotate(int[] nums, int k) {
        int len = nums.length, n = len;
        int i = 0, pos = 0, pre = nums[pos], temp = nums[pos];
        if (k % n == 0) return;
        while (n -- != 0) {
            pos = (pos + k) % len;
            temp = nums[pos];
            nums[pos] = pre;
            pre = temp;
            if (pos == i) {
                pos = ++i;
                pre = nums[pos];
                temp = nums[pos];
            }
        }
    }


}
