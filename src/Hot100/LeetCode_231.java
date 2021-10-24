package Hot100;

public class LeetCode_231 {
    // 按位运算 n & (n - 1) == 0;
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}
