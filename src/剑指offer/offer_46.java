package 剑指offer;

import java.util.*;

public class offer_46 {
    /*
    * 将数字翻译成字符串 有多少种方式
    * 被翻译的数字的部分是0-25
    * 1. 分组处理数字
    * 2. 一组有几个这样去处理*/
    // 不太会
//    public int translateNum(int num) {
//       List<Integer> list =  numToNums(num);
//       int index = 0, next = 1, res = 0;
//        for (int i = 0; i < list.size(); i++) {
//
//        }
//    }
//    // num -> nums
//    public List<Integer> numToNums(int num) {
//        List<Integer> list = new LinkedList<>();
//        int tail;
//        while (num > 0) {
//            tail = num % 10;
//            num /= 10;
//            list.add(tail);
//        }
//        Collections.reverse(list);
//        return list;
//    }

    // 明天带入数据拿笔写写画画
    // f(i)=f(i−1)+f(i−2)[i−1≥0,10≤x≤25] 动态规划转移方程
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) continue;
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
}
