package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_567 {
    // 这么想太复杂了
//    public boolean checkInclusion(String s1, String s2) {
//        ArrayList<String> list = new ArrayList<>();
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s2.length(); i++) {
//            for (int j = i; j < s2.length() ; j++) {
//                list.add(s2.substring(i, j));
//            }
//        }
//
//        for (int j = 0; j < s1.length(); j++) {
//            map.put(s1.charAt(j), map.getOrDefault(s1.charAt(j), 1));
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).length() == s1.length()) {
//                for (int j = 0; j < list.get(i).length(); j++) {
//                    map.put(list.get(i).charAt(j), map.getOrDefault(list.get(i).charAt(j) -1, -1));
//                }
//            }
//            for (Character chars: map.keySet()) {
//                if (map.get(chars) != 0) return false;
//            }
//        }
//        return true;
//    }

    public boolean checkInclusion_1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s1.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) return true;
        for (int i = n; i < m; i++) {
            // 左边减
            // 右边加
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }

    // 对比上面的方法只对于改变的量进行判断
    public boolean checkInclusion_2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            --cnt[s1.charAt(i) - 'a']; // 每个值都设置为负数
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) { // 判断长度是否是n
                return true;
            }
        }
        return false;
    }


}

