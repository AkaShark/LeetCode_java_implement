package Hot100;

import com.sun.jdi.LongValue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LeetCode_414 {
    public int thirdMax_1(int[] nums) {
        Arrays.sort(nums);
        reverse(nums,0, nums.length - 1); // 每次都逆序 不合理
        for (int i = 1, count = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && ++count == 3) {
                return nums[i];
            }
        }
        return nums[0];
    }

    private void reverse(int[] nums, int l, int r) {
        while (r > l) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            r --;
            l ++;
        }
    }

    public int thirdMax_2(int[] nums) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
            if (res.size() > 3) {
                res.remove(res.first());
            }
        }
        return res.size() == 3? res.first(): res.last();

    }

    public int thirdMax_3(int[] nums) {
        long max = Long.MIN_VALUE, middle = Long.MIN_VALUE, min = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if (num > max) {
                min = middle;
                middle = max;
                max = num;
            } else if (num < max && num > middle) {
                min = middle;
                middle = num;
            } else if (num < middle && num > min) {
                min = num;
            } else { // 小于min 不用管

            }
        }
        return min == Long.MIN_VALUE ? (int)max: (int)min;
    }


    public int thirdMax(int[] nums) {
        long[] res = new long[]{Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if (num > res[2]) {
                res[0] = res[1];
                res[1] = res[2];
                res[2] = num;
            } else if (res[2] > num && res[1] < num) {
                res[0] = res[1];
                res[1] = num;
            } else if (res[1] > num && res[0] < num) {
                res[0] = num;
            } else  { // 小于最小的不用管
                //
            }
        }
        return res[0] == Long.MIN_VALUE? (int) res[2]: (int) res[0];
    }

}
