package 剑指offer;

public class offer_10_1 {
    // 小青蛙跳台阶
    // 时间复杂度过不去
    public int numWays_1(int n) {
        int[] result = new int[]{1, 1, 2};
        if (n <= 2) return result[n];
        return numWays_1(n - 1) + numWays_1(n - 2);
    }


    // 斐波那契数列的动态规划
    public int numWays(int n) {
        // 特殊情况
        int[] result = new int[]{1, 1, 2};
        if (n <= 2) return result[n];
        // 设置初始值，设置num防止重复计算自底向上的计算
        int first_num = 1, second_num = 2, num = 0;
        for (int i = 2; i < n; i++) {
            // 结果取余 题目条件
            num = (first_num + second_num) % 1000000007;
            first_num = second_num;
            second_num = num;
        }
        return num;
    }


}
