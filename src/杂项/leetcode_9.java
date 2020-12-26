package 杂项;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class leetcode_9 {
    // 回文串 基础版本 变字数组前后对比
    public boolean isPalindrome_1(int x) {
        if(x < 0) return false;
        List<Integer> list = new ArrayList<>();
        x = Math.abs(x);
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }

        int size = list.size();
        int index = 0;

        while (index <= size) {
            if (list.get(index) != list.get(size)) return false;
            index ++;
            size --;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        // x为负数 或者 x结尾是0并且x不等于0 则直接返回false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        // 声明翻转数
        int rev = 0;
        // 当翻转数小于x的时候证明没有到一半
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 当x为奇数的时候 rev需要去掉最后一位
        return x == rev || x == rev/10;

    }


}
