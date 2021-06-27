package Hot100;

public class LeetCode_260 {
    // 只出现一次的数字3 有两个只出现一次的数字
    /*
     * 思路
     * 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
     * 在异或结果中找到任意为1的位。
     * 根据这一位对所有的数字进行分组。
     * 在每个组内进行异或操作，得到两个数字。
     */

    public int[] singleNumber(int[] nums) {
        //  求数组的异或和
        int ans = 0; // 和0异或还是本身
        for (int n : nums) {
            ans ^= n;
        }

        int div = 1;
        // 位运算
        while ((div & ans) == 0) { // 异或的结果和1做位与 位与都为1才为1  找到第一位为1的位 为1的位证明两个数不相同的位
            div <<= 1; // 左移一位 1左移一位  div就是要划分两个部分的位置
        }

        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
