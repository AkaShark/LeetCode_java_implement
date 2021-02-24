package 剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class offer_56_2 {
    // map
    public int singleNumber_1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }

        for (int k : map.keySet()) {
            if (map.get(k) == 1)
                return k;
        }
        return -1;
    }

    // 排序
    public int singleNumber_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i+1]) return nums[i];
            else if (i == nums.length - 1 && nums[i] != nums[i - 1]) return nums[i];
            else {
                if (i != 0 && i != nums.length -1 &&nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
            }
        }
        return -1;
    }

    // 位元素 不理解 快手面试 找到只出现一次的数字
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int singleNumber_3(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

}
