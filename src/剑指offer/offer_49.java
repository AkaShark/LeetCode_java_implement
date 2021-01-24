package 剑指offer;

public class offer_49 {
    // 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
    // 暴力法解决判断0-n的每个数是否是丑数
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n]; // 使用dp数组来存储丑数序列
        dp[0] = 1; // 1为丑数 默认为dp的第0个元素
        for (int i = 1; i < n; i++) { // 循环n-1次
            // 获取下一个丑数的可能（*2 *3 *5）
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            // 获取第i+1个丑数  是所有可能的最小值 因为要保证生成丑数的顺序
            dp[i] = Math.min(Math.min(n2, n3), n5);
            // 判断新生成的丑数是哪个可能产生的 =》 这个个a/b/c 完成了使命下个要成的数是a/b/c+1
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1]; // dp[i] 表示第i+1位丑数 则第n位为 dp[n - 1]

    }
}
