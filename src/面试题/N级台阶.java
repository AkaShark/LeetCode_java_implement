package 面试题;

public class N级台阶 {
    public static class Test {
        static final int s = 100; //自定义的台阶数

        static int compute(int stair){
            if ( stair <= 0){
                return 0;
            }
            if (stair == 1){
                return 1;
            }
            if (stair == 2){
                return 2;
            }
//            递归调用
            return compute(stair-1) + compute(stair-2);
        }

        static public void main(String args[]) {
            System.out.println("共有" + ClimbStairs(10) + "种走法");
        }

        static int ClimbStairs(int n)
        {
            int[] dp = new int[]{1,1,0};
            if (n < 2)
            {
                return 1;
            }
            for (int i = 2; i <= n; i++)
            {
                dp[2] = dp[0] + dp[1];
                dp[0] = dp[1];
                dp[1] = dp[2];
            }
            return dp[2];
        }
    }
//    https://blog.csdn.net/Hackbuteer1/article/details/6686747 衍生题 跳n级

}
