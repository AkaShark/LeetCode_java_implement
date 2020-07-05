package 链表;

import java.util.HashMap;
import java.util.Map;

public class Hard_76_最小覆盖子串 {
//    滑动窗口的思想就是有两个指针一个left一个right，他们之间的叫做窗口，right指针负责扩大窗口
//    不断的去寻找合适的解去（疯狂的边缘试探 left指针负责缩小窗口，在试探不满足条件的时候left负责兜底
//   用两个HashMap去做的实现，窗口的设置

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> dicT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count + 1);
        }
        int required = dicT.size();
        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};
        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dicT.containsKey(c) && windowCounts.get(c).intValue() == dicT.get(c).intValue()) {
                formed++;
            }

            while (l < r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dicT.containsKey(c) && windowCounts.get(c).intValue() < dicT.get(c).intValue()) {
                    formed--;
                }
                l++;

            }
            r++;
        }
        return ans[0] == -1 ? "":s.substring(ans[1],ans[2]+1);
    }
}
