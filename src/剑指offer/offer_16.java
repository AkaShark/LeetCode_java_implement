package 剑指offer;

public class offer_16 {
    // 难度在于要思考全面 负数情况 为0的情况
    public double myPow_1(double x, int n) {
        // 底数为0 指数为负数的情况
        if (x == 0 && n < 0) return 0;
        long abs_n = Math.abs(n);
        double res = power(x, abs_n);
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    // 快速幂求法 n % 2 判断是否为奇数 可以用 n & 1 来替换 为1 则为奇数
    // 快速幂计算时间复杂度为对数级别
    // 二进制角度
    public double power(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        // 位移运算代替除以2 这里用递归的话会导致栈溢出了
        double res = power(x, n >> 1);
        res *= res;
        // 代替去模运算 判断是奇数还是偶数
        if ((n & 0x1) == 1) res *= x;
        return res;
    }

    // 基础版本 需要循环n次 时间复杂度过不去
    public double power_1(double x, int n) {
        double res = 1.0;
        for (int i = 1; i <= n; i++) {
            res = res * x;
        }
        return res;
    }


    // leetCode 上的答案 二分法角度 直接循环计算 不会出现栈溢出的情况
    public double myPow(double x, int n) {
        // x = 0 直接返回 防止出现分母为0的时候
        if (x == 0) return 0;
        // 初始化结果
        double res = 1.0;
        // 计算n的绝对值
        int abs_n = Math.abs(n);
        // 利用二分法求幂 快速幂的实现
        while (abs_n > 0) {
            // 当n为奇数的时候现一次
            if ((abs_n & 1) == 1) res *= x;
            // 循环每次都是平方
            x *= x;
            // n 除以 2
            abs_n >>= 1;
        }
        // 如果n是负数则取倒数
        if (n < 0) res = 1 / res;

        return res;
    }

    // leetcode 分享的答案
    public double myPow_2(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
