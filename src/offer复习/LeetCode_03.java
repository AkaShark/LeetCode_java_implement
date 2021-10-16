package offer复习;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_03 {
    public int lengthOfLongestSubstring_1(String s) {
        ArrayList<Set<Character>> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    res.add(set);
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() > ans) {
                ans = res.get(i).size();
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring_2(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.removeAll(set);
            int temp = 0;
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) break;
                temp ++;
            }
            ans = temp > ans? temp: ans;
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, right = -1;
        Set<Character> set = new HashSet<>();
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1)); // 最左边的移除调
            }
            while (right + 1 < s.length() && !set.add(s.charAt(right + 1)))
                right ++;
            ans = Math.max(right - left + 1, ans);
        }
        return ans;

    }



}
