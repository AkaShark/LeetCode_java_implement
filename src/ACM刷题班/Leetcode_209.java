package ACM刷题班;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_209 {
    // O(n2) 解法 暴力法
    public int minSubArrayLen_0(int s, int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = Math.min(res, j - i + 1);
                }
            }
        }
        return res;
    }


    public int minSubArrayLen_1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int res = Integer.MAX_VALUE;
        // 为了方便计算，令 size = n+1
        // sum[0] = 0 前0个元素的前缀和
        // sum[1] = num[0] 前1个元素的前缀和
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        for (int i = 1; i <= n ; i++) {
            int target = s + sums[i-1];
            //如果key在数组中，则返回搜索值的索引；否则返回-1或者”-“(插入点)。插入点是索引键将要插入数组的那一点，即第一个大于该键的元素索引。
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                // 没有找到 但是返回需要插入的位置
                bound = -bound-1;
            }
            // 找到target
            if (bound <= n) {
                // 长度
                res = Math.min(res, bound - (i - 1));
            }
        }
        return res == Integer.MAX_VALUE ? 0 :res;

    }

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start +1);
                sum -= nums[start];
                start++;
            }
            end ++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
