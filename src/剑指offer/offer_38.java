package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class offer_38 {
    /*
    * 输入一个字符串返回字符串的全排列
    * 输入的字符串有重复的元素的特殊处理
    * 解决失败看下leetCode题解
    */
    static public String[] permutation_1(String s) {
        if (s.length() == 0) return null;
        char[] chars = s.toCharArray();
        List<String> res = new LinkedList<>();
        int index = 0;

        // 外层循环
        for (index = 0;  index < chars.length; index++) {
            int end = chars.length - 1, start = 0;
            for (; start <= end; end --) {
                String tempStr = new String(chars);
                if (!res.contains(tempStr)) res.add(tempStr);
                swap(chars, start, end);
            }

        }
        String[] resStr = res.toArray(new String[res.size()]);

        return resStr;
    }

    static public void swap(char[] chars, int index1, int index2) {
        if (chars != null && chars.length > 0) {
            char temp = chars[index1];
            chars[index1] = chars[index2];
            chars[index2] = temp;
        }
    }


    /*LeetCode*/
    // 深度优先搜索 先固定第一个字符 再固定第二个字符 。。。。。
    // 重复方案解决 保证每种字符只在此位固定一次 从 DFS 角度看，此操作称为 “剪枝” 。

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        // dfs
        dfs(0);
        // list转数组
        return res.toArray(new String[res.size()]);
    }
    // 递归交换 确定总的可能的次数 x表示固定的位数
    void dfs(int x) {
        // 当 x =  c.length - 1 的时候表示固定最后一位就一种情况了
        if (x == c.length -1) {
            // 将结果添加进res中
            res.add(String.valueOf(c));
        }
        // 声明一个set
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length ; i++) {
            // 如果set中包含c[i] 则证明同一个位置上有重复的元素出现了 这样的话就直接跳过重复的元素即 continue
            if (set.contains(c[i])) continue;
            // 添加到set中
            set.add(c[i]);
            swap(i, x); // 交换将c[i] 固定到x位
            dfs(x + 1); // 固定第x+1位
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}


