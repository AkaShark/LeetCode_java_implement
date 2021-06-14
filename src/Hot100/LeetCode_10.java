package Hot100;

public class LeetCode_10 {
    // 青蛙跳台阶
    public int numWays_1(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                f[i] += f[i - 1];
            } else {
                f[i] += (f[i - 1] + f[i - 2]) % 1000000007;
            }
        }
        return f[n];
    }

    // 简化版
    public int numWays(int n) {
        int a = 1, b = 1, c = 0;
        for (int i = 0; i < n ; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        r

}
