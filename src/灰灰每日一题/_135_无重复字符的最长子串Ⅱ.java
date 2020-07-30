package 灰灰每日一题;

import java.util.HashSet;
import java.util.Set;

public class _135_无重复字符的最长子串Ⅱ {
    // 时间复杂度 O()
    public int lengthOfLongestSubString(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int asn = 0, i = 0, j = 0; // i为左 j为右
        while (i < n && j < n) {
//            不包含的话插入一个
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++)); // 右边距开始移动
                asn = Math.max(j-i,asn);
            } else {
                set.remove(s.charAt(i++)); // 左边边距开始移动 set减小一个 从i++开始
            }
        }
        return asn;
    }
}