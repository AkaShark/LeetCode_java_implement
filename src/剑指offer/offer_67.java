package 剑指offer;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.ArrayList;
import java.util.List;

public class offer_67 {
    // 我崩了 就是这个思路 各种规避case 但是乱的不行
    boolean flag = false;
    public int strToInt(String str) {
        str = str.trim(); // 去除前后的空格
        if (str == null || str.length() == 0 || str.equals(" ")) return 0;
        if (str.charAt(0) < '0' && str.charAt(0) > '9' && (str.charAt(0) != '+' && str.charAt(0) != '-')) return 0;
        int res = 0;
        // 是有效数组
        if (str.charAt(0) == '+' || str.charAt(0) == '-') { // 带正负号
            res = str.charAt(0) == '+'? intNum(str.substring(1)) : -intNum(str.substring(1));
        } else { // 数字
            res = intNum(str);
        }
        return !flag ? res : str.charAt(0) == '+' || (str.charAt(0) >= '0' && str.charAt(0) <= '9')? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public int intNum(String subStr) {
        if (subStr == null || subStr.length() == 0) return 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < subStr.length(); i++) {
            if (subStr.charAt(i) >= '0' && subStr.charAt(i) <= '9') {
                nums.add((subStr.charAt(i) - '0'));
            } else {
                break;
            }
        }
        int res = 0;
        for (int i = nums.size() - 1, j = 1; i >= 0; i--, j *= 10) {
            res += nums.get(i) * j;
            if (res > Integer.MAX_VALUE - nums.get(i) * j) flag = true;
        }
        return res;
    }
}
