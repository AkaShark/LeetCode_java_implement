package Hot100;

public class leetCode_69_2 {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int left = 0, right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // 上取整
            if ((long)mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
