package 面试准备;

import java.util.*;

public class LeetCode_20 {

    // 字符串匹配
    public boolean isValid_1(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '(' && stack.peek() == ')') stack.pop();
                else if (s.charAt(i) == '[' && stack.peek() == ']') stack.pop();
                else if (s.charAt(i) == '{' && stack.peek() == '}') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Map<Character, Character> pairs = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        // 栈
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
