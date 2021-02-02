package 剑指offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.Array;
import java.util.*;

public class offer_56_1 {
    /*
    * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
    * 请写程序找出这两个只出现一次的数字。
    * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     */
    // map 时间复杂度是O(n) 但是空间复杂度是O(n)
    public int[] singleNumbers_1(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else  {
                map.put(nums[i], 1);
            }
        }
        List<Integer> res = new LinkedList<>();
        for (Integer index: map.keySet()) {
            if (map.get(index) == 1) {
                res.add(index);
            }
        }
        int[] resArray = new int[res.size()];
        int i = 0;
        for (int e : res)
            resArray[i++] = e;
        return resArray;
    }

    // 排序 时间复杂度是Nlogn 空间是1 不对 实现不好实现 放弃了
    public int[] singleNumbers_2(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums[nums.length - 1];
        Arrays.sort(nums);
        int i = 0, temp = nums[0], index = 0 ;
        int[] res = new int[2];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == nums[j + 1]) {

            } else {
                res[index++] = nums[j];
                if (index == 2) break;
            }
        }
//        if (index == 1) res[1] = n;

        return res;
    }

    // LeetCode 时间复杂度O(n) 空间复杂度O(1)
    // 分组异或
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n :nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
