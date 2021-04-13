package BinarySearch;

public class LeetCode_633 {
    // 时间复杂度O(n) 双指针解决
    public boolean judgeSquareSum_1(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (right >= left) {
            int sum = left * left + right * right;
            if (sum > c) {
                right --;
            } else if (sum < c) {
                left ++;
            } else {
                return true;
            }
        }
        return false;
    }

    // 二分法 确定a的值 二分法枚举b的值 时间复杂度O(nLogN)
    public boolean judgeSquareSum_2(int c) {
        for (long i = 0; i*i <= c; i++) {
            int b = c - (int)(i * i);
            if (binary_search(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    public boolean binary_search(long left, long right, int n) {
        if (left > right) return false;
        long mid = left + (right - left) / 2;
        if (mid * mid == n) return true;
        if (mid * mid > n) return binary_search(left, mid - 1, n);
        return binary_search(mid + 1, right, n);
    }

    // 使用sqrt函数 判断找到的B是否是整数
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }

    // 费马平方定理不理解pass





}
