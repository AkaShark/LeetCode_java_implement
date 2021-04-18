package Hot100;

public class LeetCode_69 {
    public int mySqrt(int x) {
        int l = 0, r = x/2, ans = -1;
        while (r > l) {
            int middle = l + (r - l ) / 2;
            if (middle * middle > x) {
                r = middle - 1;
            } else {
                l = middle;
                ans = middle;
            }
        }

        return ans;
    }
}
