package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class offer_48 {
    // 暴力法访问 时间复杂度是O(n3)
    public int lengthOfLongestSubstring_1(String s) {
        return -1;
    }

    // 动态规划 + hash表实现
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = dic.getOrDefault(s.charAt(i), -1); // 获取索引 i
            tmp = tmp < j - i? tmp + 1: j- i; //dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j]);
        }
        return res;
    }


}
