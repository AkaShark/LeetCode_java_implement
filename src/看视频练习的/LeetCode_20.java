package 看视频练习的;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode_20 {

//    没有思考全情况！！！ 要先想好所有的case 然后再开始写代码 切题四件套 而且代码写的比较乱 思路不明确 要确定好了 再开始动手
//    public boolean isValid(String s) {
//        if (s.length() % 2 != 0) return false;
//        if (s.length() <= 0) return true;
//        if (s.charAt(0)!='('&& s.charAt(0)!='['&& s.charAt(0)!='{') return false;
//        Stack<Character> stack = new Stack<>();
//        int len = 0;
//        while (len < s.length()) {
////            左括号
//            if (s.charAt(len) == '(' || s.charAt(len) == '[' || s.charAt(len) == '{') {
////                进栈
//                stack.push(s.charAt(len));
//            } else { // 右括号
//                Character topChart = stack.peek();
//                if (( s.charAt(len) == '}' && topChart == '{' )||(  s.charAt(len) == ']' && topChart == '[' )||(  s.charAt(len) == ')' && topChart == '(')) {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//
//            len++;
//        }
//        System.out.println(stack.empty());
//        if (stack.empty()){
//            return true;
//        }
//        return false;
//
//    }


    //    leetcode
//    public boolean isValid(String s) {
//        HashMap<Character, Character> mappings = new HashMap<>();
//        mappings.put(')', '(');
//        mappings.put('}', '{');
//        mappings.put(']', '[');
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (mappings.containsKey(c)) {
//                char topChar = stack.empty() ? '#' : stack.pop();
//                if (topChar != mappings.get(c)) {
//                    return false;
//                }
//            } else {
//                stack.push(c);
//            }
//        }
//        return stack.isEmpty();
//
//    }

    public boolean isValid(String s) {
        if (s.length() == 0 || s == null) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
           switch (ch){
               case '{':
                   stack.push('}');
                   break;
               case '(':
                   stack.push(')');
                   break;
               case '[':
                   stack.push(']');
                   break;
               default:
                   if (stack.pop()!=ch || stack.empty() ){
                       return false;
                   }
                   break;
           }
        }
        

        return true;
    }
}
