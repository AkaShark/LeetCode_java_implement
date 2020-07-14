package 看视频练习的;

import java.util.Arrays;
import java.util.HashMap;
/** 主要是判断两个问题 ①字符是否相同 ②字符对应的个数是否相同 */
public class LeetCode_242 {
    /** 将String转Char[] 利用Arrays的排序方法 在将char[] 转String equals 判断string是否相等  87% */
//    public boolean isAnagram(String s, String t) {
//         char[] sChars = s.toCharArray();
//         char[] tChars = t.toCharArray();
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//        return String.valueOf(sChars).equals(String.valueOf(tChars));
//    }

    /** 利用HashMap 判断是否相同 15.57% */
//    public boolean isAnagram(String s, String t) {
//        /* map 中存储 字符和字符出现的次数 */
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (char ch : s.toCharArray()) {
//            /* map 存储ch 出现的个数 如果已经有了则+1  */
//            map.put(ch,map.getOrDefault(ch,0)+1);
//        }
//        for (char ch : t.toCharArray()) {
//            /*获取t的字符在map中出现的个数*/
//            Integer count = map.get(ch);
//            if (count == null) {
//                /* 没有 返回 false */
//                return false;
//            } else if (count > 1) { // 如果有的话个数-1
//                map.put(ch,count-1);
//            } else { // 个数为0 删除
//                map.remove(ch);
//            }
//        }
//        /*判断map是否为空*/
//        return map.isEmpty();
//    }
    /** 利用 ASIIC码 对应的值*/
    public boolean isAnagram(String s, String t) {
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        for (char ch : s.toCharArray()) {
            sChars[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            tChars[ch-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sChars[i] != tChars[i]) return false;
        }
        return true;
    }
}
