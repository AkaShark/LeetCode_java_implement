package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class offer_39 {
    // 查找的问题 如何快速的找到出现次数最多的元素
    // map 查找
    // ps 建立map映射之后访问的是map对象了
    // 19ms
    public int majorityElement(int[] nums) {
        if (nums.length <= 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            } else {
                int temp = map.get(nums[i]) + 1;
                map.put(nums[i], temp);
            }
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) >= nums.length / 2) {
                return i;
            }
        }
        return -1;

    }



    // 排序实现
    // 将数组 nums 排序，数组中点的元素 一定为众数。
    // 2ms
    public int majorityElement_1(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        Arrays.sort(nums);
        int middle = nums.length / 2;
        return nums[middle];
    }

    // 投票法 相互抵消

    /*
    根据以上推论，假设数组首个元素 n_1n 为众数，遍历并统计票数。当发生 票数和 = 0=0 时，剩余数组的众数一定不变
    利用此特性，每轮假设发生 票数和 = 0=0 都可以 缩小剩余数组区间 。当遍历完成时，最后一轮假设的数字即为众数。

        算法流程:
        初始化： 票数统计 votes = 0 ， 众数 x；
        循环： 遍历数组 nums 中的每个数字 num ；
        当 票数 votes 等于 0 ，则假设当前数字 num 是众数；
        当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
        返回值： 返回 x 即可；
*/
    //1ms
    public int majorityElement_2(int[] nums) {
        if (nums == null || nums.length <=0) return -1;
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num; // 当投票结果为0的时候选择当前数字为众数
            votes += num == x ? 1 : -1; // 当当前数字为选择的众数的时候票数+1 否则-1;
        }
        // 最后的结果为最后一次选择的众数
        return x;
    }

    // 投票加验证
    // ps 摩尔投票法找的其实不是众数，而是占一半以上的数。当数组没有超过一半的数，则可能返回非众数，比如[1, 1, 2, 2, 2, 3, 3]，最终返回3。
    //
    //投票法简单来说就是不同则抵消，占半数以上的数字必然留到最后。
    public int majorityElement_3(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        int x = 0, votes = 0;
        for (int num: nums) {
            if (votes == 0) x = num;
        }

        // 验证x是否为众数
        int count = 0;
        for (int num : nums)
            if (num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数的返回0

    }
}
