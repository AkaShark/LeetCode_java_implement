package Hot100;

public class LeetCode_offer_10 {
    public int fib_1(int n) {
        // n - 1   n      n + 1
        int a = 0, b = 1, sum;
        for (int i = 0; i <= n; i++) {
            sum = (a + b) % 1000000007;
             a = b;
             b = sum;
        }
        return a;
    }

    public int fib_2(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                f[i] += f[i - 1];
            } else {
                f[i] += (f[i - 1] + f[i - 2]) % 1000000007;
            }
        }
        return f[n];
    }

    // 递归
    public int fib(int n) {
        // 递归出口
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n-1) + fib(n-2)) % 1000000007;
    }
}
