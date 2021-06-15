package Hot100;

import java.util.*;

public class LeetCode_offer_50 {
    public char firstUniqChar_1(String s) {
        if (s == null || s.length() == 0) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public char firstUniqChar_2(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }

    public char firstUniqChar_3(String s) {
        // 有序hash表 LinkedHashMap 产生的hashMap的序列默认是插入的顺序
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        // 遍历
        for (char c: chars)
            dic.put(c, !dic.containsKey(c)); // 如果包含的话一定是返回的false 第一次是true
        for (Map.Entry<Character, Boolean> d :dic.entrySet()) { // 返回的是插入顺序 获取的是map的Entry
            if (d.getValue()) return d.getKey(); // 获取第一个为true的
        }
        return ' ';
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll().ch;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

}
