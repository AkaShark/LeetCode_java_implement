package Hot100;

public class LeetCode_441 {
    public int arrangeCoins_1(int n) {
        long num = n;
        long res = 1;
        for (long i = 1; i < num; i++) {
            if (i * (i + 1) > num * 2) {
                break;
            }
            res = i;
        }
        return (int) res;
    }

    // 二分法解决
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (right > left) {
            int mid = (right - left ) / 2 + left;
            if (mid * (mid + 1) >= 2 *n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
