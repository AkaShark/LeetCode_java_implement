package 链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mid_3_无重复字符的最长子串 {

    //  暴力法 循环判断 所有的子串是否满足 没有重复的条件
//    static public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j <=n ; j++) {
//                if (allUnique(s,i,j)) ans = Math.max(ans,j-1);
//            }
//        }
//        return ans;
//    }
//    static public boolean allUnique(String s,int start,int end){
//        Set<Character> set  = new HashSet<>();
//        for (int i =start; i<end;i++){
//            Character ch = s.charAt(i);
//            if (set.contains(ch)) return false;
//            set.add(ch);
//        }
//        return true;
//    }


    //    滑动窗口问题 KMP算法似的
    //  滑动窗口法-1
//    static public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j));
//                ans = Math.max(ans, j - i);
//            } else {
////                向左步长为1
//               set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }


    //  滑动窗口法-2 优化
    static public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
//    防止left向左过分
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
//      添加或者是更新
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

//    思路差不多就是用数组去代替HashMap去做判断
//    static public int lengthOfLongestSubstring(String s) {
//        int n = s.length(),ans = 0;
//        int [] index = new int[128];
//        for (int j = 0,i=0; j < n; j++) {
//            i = Math.max(index[s.charAt(j)],i);
//            ans = Math.max(ans,j-1+1);
//            index[s.charAt(j)] = j+1;
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
