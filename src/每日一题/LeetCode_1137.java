package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_1137 {
    /*
    * 时间复杂度比较高的方法是递归处理 但是简单
    * 时间复杂度比较好的就是用 动态规划处理
    * */
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1, d = 4;
        int[] list = new int[]{a, b, c};
        if (n < 3) {
            return list[n];
        }

        for (int i = 3; i < n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
            System.out.println(d);
        }
        return d;
    }

    public int tribonacci_1(int n) {
        int a = 0, b = 1, c = 1;
        int[] list = new int[]{a, b, c};
        if (n < 3) {
            return list[n];
        }
        return tribonacci_1(n - 1);
    }

    public int tribonacci_2(int n) {
        int a = 0, b = 1, c = 1;
        int[] list = new int[]{a, b, c};
        if (n < 3) {
            return list[n];
        }
        ArrayList array = new ArrayList();
        array.addAll(Arrays.asList(list));
        System.out.println(array.size());
        for (int i = 3; i <= n; i++) {
            int sum = (int) array.get(i) + (int)array.get(i - 1) + (int)array.get(i - 2);
            array.add(sum);
        }
        return (int)array.get(n);
    }



}
