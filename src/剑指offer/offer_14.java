package 剑指offer;

import static java.lang.Math.pow;

public class offer_14 {

    // 动态规划需要从上往下的思考，并且从下往上的解决问题（避免子问题重复计算）
    // 动态规划
    /*
    * 1. 任何大于1的数都可由2和3组成（根据奇数偶数证明）
    * 2. 将数字拆成2和3能得到积最大
    *  */
    public int cuttingRope(int n) {
        if (n < 2)  return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] products = new int[n + 1];
        /*
        * 下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
        这里的3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
        * */
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;

        // 这里的循环是从4开始的也就是从下往上的计算
        for (int i = 4; i <= n; i++) {
            max = 0; // 记录最大值
            // 这里的j <= i/2 是因为1*3 3*1 是一样的 所以只需要求到一半的数就可以了
            // 这里的循环f(j) 都是已经求解出来的 为了找到最大的f(i) 需要遍历所有的可能
            for (int j = 1; j <= i/2 ; j++) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        /*
        * 子问题的最优解存储在数组products里面
        * 数组中的第i个元素表示把长度为i的剪成若干段长度乘积的最大值
        * 也就是f(i)
        * */
        max = products[n];
        return max;
    }


    // 贪心需要选择贪心策略 需要用数学的方法去证明
    /*
    * 贪心算法
    * 贪心策略：
    * 当n 大于等于5 的时候我们尽可能的剪成长度为3的绳子，当不可能剪成长度为3 的时候尽可能剪出长度为2的线段
    * 这种贪心选择 需要通过数学的证明
    * 当绳子大于五的时候我们把他剪成长度为2或者3的绳子段 而且应该尽可能多的剪出长度为3的线段
    *
    * */

    public int cuttingRope_1(int n ) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        // 尽可能剪出3 则 剪出3的个数
        int times_3 = n / 3;
        // 当最后长度为4的时候不能减出长度为3的绳子 因为 长度为4剪出2个长度为2的线段乘积最大
        if (n - times_3 * 3 == 1) times_3 -= 1;

        int times_2 = (n - times_3 * 3) / 2;
        // 这里的数学证明看下 leetcode上的解析

        return (int) (Math.pow(3, times_3)) * (int) (Math.pow(2, times_2));

    }
}
