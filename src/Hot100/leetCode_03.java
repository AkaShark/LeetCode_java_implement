package Hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class leetCode_03 {
    // 时间复杂度高 遍历的方式添加元素
    public int lengthOfLongestSubstring_1(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            set.removeAll(set);
            int temp = 0;
            for (int j = i; j < strs.length; j++) {
                if (!set.add(strs[i])) break; // 添加到set中如果添加不进去的证明已经存在了 则记录长度 break
                temp++;
            }
            max = temp >= max ? temp : max;
        }
        return max;
    }

    // 滑动窗口 避免重复元素的重复访问 O(n)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); // 窗口
        int n = s.length(); // 长度
        int rk = -1, ans = 0; // rk为右指针
        for (int i = 0; i < n; i++) {
            if (i != 0) set.remove(s.charAt(i - 1)); // 如果跳出来了的话证明有重复了 移除前一个元素
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) { // 向右移动 判断是否重复
                // 不断移动右指针
                set.add(s.charAt(rk + 1));
                ++ rk;
            }
            ans = Math.max(ans, rk - i + 1); // 右减去左 + 1
        }
        return ans;
    }
}
