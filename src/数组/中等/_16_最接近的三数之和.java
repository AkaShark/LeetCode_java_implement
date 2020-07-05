package 数组.中等;

import java.util.ArrayList;
import java.util.Arrays;

public class _16_最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i+1,right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (Math.abs(target-sum)<Math.abs(target-ans)) ans = sum;
//                双指针
                if (sum>target) right--;
                else if (sum<target) left++;
//                相等
                else return ans;
            }
        }

        return ans;
    }

}
