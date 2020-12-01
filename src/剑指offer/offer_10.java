package 剑指offer;

public class offer_10 {
    // 普通递归直接 时间复杂度都过不去了 有很多的重复计算 从上到下的计算
    public int fib_0(int n) {
        if (n == 1) return 0;
        else if (n == 2) return 1;
        else return fib_0(n-1) + fib_0(n - 2);
    }

    // 从下到上上的计算 这个样的话可以优化算法 省去很多重复计算
    public int fib (int n) {
        int[] result = new int[]{0,1};
        if (n < 2) return result[n];

        int fib_first = 0;
        int fib_second = 1;
        int fib_result = 0;
        for (int i = 2; i <= n; i++) {
            fib_result = (fib_first + fib_second) % 1000000007;
            fib_first = fib_second;
            fib_second = fib_result;
        }
        return fib_result;
    }

}
