package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class offer_57_2 {

    // 暴力法 时间复杂度高
    List<int[]> res = new ArrayList<>(); // List内部包的是int[]
    public int[][] findContinuousSequence_1(int target) {
        for (int i = 1; i < target; i++) {
            sumWithTarget(target, i);
        }
        return res.toArray(new int[res.size()][]);

    }

    public void sumWithTarget(int target, int num) {
        int sum = 0;
        for (int i = num; i > 0 ; i -- ) {
            sum += i;
            if (sum == target) {
                int[] list = new int[num - i + 1];
                for (int j = i; j <= num; j++) {
                    list[j - i] = j;
                }
                res.add(list);
                break;
            } else if (sum > target) {
                break;
            }
        }
    }

    // LeetCode 暴力法
    public int[][] findContinuousSequence_2(int target) {
        List<int[]> vec = new ArrayList<>();
        int sum = 0, limit = (target - 1) / 2; // 等价于target / 2 向下取整 从后向前加的到一本就可以停下来了
        for (int i = 1; i <= limit ; i++) {
            for (int j = i; ; j++) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j ; k++) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    // LeetCode 暴力解法 优化 求根公式
    public int[][] findContinuousSequence_3(int target) {
        List<int[]> vec = new ArrayList<>();
        int sum = 0, limit = (target - 1) / 2;
        for (int x = 1; x <= limit ; x++) {
            // 求根
            long delta = 1 - 4 * (x - (long) x * x - 2 * target); // delta
            if (delta < 0 ) continue;
            int delta_sqrt = (int) Math.sqrt(delta + 0.5); // 为什么加上0.5 不加也对！
            /*两个条件
            * 1. 判别式 delta 开根需要为整数
            * 2. 最后的求根公式的分子需要为偶数，因为分母为 2*/
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2;
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y ; i++) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    // 双指针
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) { // 等于target 需要枚举下一个起点
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    res[i - l] = i;
                }
                vec.add(res);
                l ++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

}
