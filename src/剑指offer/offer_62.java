package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class offer_62 {
    // 约瑟夫环问题 模拟实现
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n; // n个元素数到头从头数对n去mod
            list.remove(index);
            n --;
        }
        return list.get(0);
    }

    // 数学方法解决 反推问题
    public int lastRemaining_1(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
