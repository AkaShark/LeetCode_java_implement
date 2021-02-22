package 剑指offer;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.ArrayList;
import java.util.List;

public class offer_67 {
    // 我崩了 就是这个思路 各种规避case 但是乱的不行
//    boolean flag = false;
//    public int strToInt(String str) {
//        str = str.trim(); // 去除前后的空格
//        if (str == null || str.length() == 0 || str.equals(" ")) return 0;
//        if (str.charAt(0) < '0' && str.charAt(0) > '9' && (str.charAt(0) != '+' && str.charAt(0) != '-')) return 0;
//        int res = 0;
//        // 是有效数组
//        if (str.charAt(0) == '+' || str.charAt(0) == '-') { // 带正负号
//            res = str.charAt(0) == '+'? intNum(str.substring(1)) : -intNum(str.substring(1));
//        } else { // 数字
//            res = intNum(str);
//        }
//        return !flag ? res : str.charAt(0) == '+' || (str.charAt(0) >= '0' && str.charAt(0) <= '9')? Integer.MAX_VALUE : Integer.MIN_VALUE;
//    }
//
//    public int intNum(String subStr) {
//        if (subStr == null || subStr.length() == 0) return 0;
//        List<Integer> nums = new ArrayList<>();
//        for (int i = 0; i < subStr.length(); i++) {
//            if (subStr.charAt(i) >= '0' && subStr.charAt(i) <= '9') {
//                nums.add((subStr.charAt(i) - '0'));
//            } else {
//                break;
//            }
//        }
//        int res = 0;
//        for (int i = nums.size() - 1, j = 1; i >= 0; i--, j *= 10) {
//            res += nums.get(i) * j;
//            if (res > Integer.MAX_VALUE - nums.get(i) * j) flag = true;
//        }
//        return res;
//    }
    // 思路差不多 但是编码实现能力比我强多了 简洁 思路清晰
    public int strToInt_1(String s) {
        double res = 0.0, flag = 1.0;
        s="^"+s+"$"; //设置首位标志
        char[]cs=s.toCharArray();
        int i=1; //申请变量
        char c = cs[i];
        while( c == ' ' ) c = cs[++i]; //过滤空格，题目要求
        if(c=='-'){
            flag=-1.0;
            c=cs[++i];
        } else if(c == '+') {
            c = cs[++i];
        }
        while('0'<= c && c <='9') {
            res = res*10 + c -'0';
            c = cs[++i];
        }
        res *= flag;//按位读入
        return res > 2147483647.0 ? 2147483647: res < -2147483648.0 ? -2147483648 : (int)res;
    }

    // LeetCode 思路类似 重点是实现方式上 比我强很多 重点是代码思路清晰
    public int strToInt_2(String s) {
        char[] c = s.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bndry || res == bndry && c[j] > '7') return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    // 不使用 trim()/strip()
    public int strToInt(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }


}
