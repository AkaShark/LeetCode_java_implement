package 剑指offer;

public class offer_49 {
    // 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
    // 暴力法解决判断0-n的每个数是否是丑数
    public int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        if (n == 1 || n == 2 || n == 3) return n;
        int index = 0, res = 0;
        for (int i = 3; n < 0; i++) {

            while (i % 2 == 0 && i > 0) {
                i /= 2;
                while (i % 3 == 0 && i > 0) {
                    i /= 3;
                    while (i % 5 == 0 && i > 0) {
                        i /= 5;
                    }
                }
            }

            if (i == 0) {
                n --;
            }
            if (n == 1) res = i;
        }

         return res;

    }
}
