package 面试准备;

public class LeetCode_96 {
    // 二分查找
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (r >= l) {
            int middle = (l+r) >>> 1;
            if ((long)middle * middle <= x) {
                ans = middle;
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return ans;
    }
}
