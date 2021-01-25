package 剑指offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class offer_50 {
    /*
    * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    * */
    // 暴力法遍历 hashMap 解决
    public char firstUniqChar_1(String s) {
        if (s.length() == 0 || s.equals(" ")) return ' ';
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 0);
            } else {
                int tmp = map.get(chars[i]) + 1;
                map.put(chars[i], tmp);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 0) return chars[i];
        }
        return ' ';
    }

    // LeetCode 版本HashMap
    public char firstUniqChar_2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c :chars) dic.put(c, !dic.containsKey(c));
        for (char c :chars)
            if (dic.get(c)) return c;
        return ' ';
    }

    // 有序HashMap版本 不是有序么。。。
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars)
            dic.put(c, !dic.containsKey(c));
        for (char c : dic.keySet()) {
            System.out.println(c);
            System.out.println(dic.get(c));
        }
        for (Map.Entry<Character, Boolean> d :dic.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
