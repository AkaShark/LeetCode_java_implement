package ACM刷题班;

import java.util.Arrays;

public class LeetCode_455 {

    // 原始方法 两重循环
    public int findContentChildren_0(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int len_g = g.length;
        int len_s = s.length;
        int res = 0;
        for (int i = len_s - 1; i >= 0; i--) {
            for (int j = len_g - 1; j >= 0; j--) {
                if (s[i] >= g[j] && g[i] != -1) {
                    res++;
                    g[j] = -1;
                    break;
                }
            }
        }
        return res;
    }

    // 优化 去掉一重循环
    public int findContentChildren_1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int len_g = g.length;
        int len_s = s.length;
        int res = 0;
        int i = 0;
        for (Integer item : s) {
            if (i == len_g) break;
            if (g[i] <= item) {
                res++;
                i++;
            }
        }
        return res;
    }

    // LeetCode 预排序+双指针
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a = 0, b = 0;
        int res = 0;
        while (a < g.length && b < s.length) {
            if (g[a] <= s[b]) {
                res++;
                a++;
                b++;
            } else {
                b++; // 饼干++ 目的是满足胃口最小的孩子
            }
        }
        return res;
    }


}
