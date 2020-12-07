package 剑指offer;

public class offer_10_2 {
    //  f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
    //  由上到下 到 由下到上 可以避免中间的很多重复计算
    // 这个还是不对 下面的精简版本是没问题的 通过找规律和合并同类型 简化了问题
    public int JumpFloorII(int target) {
        int[] result = new int[]{1, 1, 2};
        if (target <= 2) return result[target];

        int first = 1, second = 1, sum = 0;
        for (int i = 0; i < target -1; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum + 1; // f(0) 为 1 加上
    }


    // 简化版本
    /*
      f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
      f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
      可以得出：
      f(n) = 2*f(n-1)
    * */
    public int JumpFloorII_1(int target) {
        if(target == 0) {
            return -1;
        }

        if(target == 1) {
            return 1;
        }

        return 2*JumpFloorII_1(target - 1);
    }

}
