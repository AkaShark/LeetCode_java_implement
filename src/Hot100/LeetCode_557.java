package Hot100;

import java.util.ArrayList;

public class LeetCode_557 {
    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i ++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - p - 1)); // 倒着添加的
            }
            while (i < length && s.charAt(i) == ' ') {
                i ++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
