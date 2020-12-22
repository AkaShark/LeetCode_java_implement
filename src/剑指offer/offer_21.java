package 剑指offer;

public class offer_21 {

    public int[] exchange_1(int[] nums) {
        if (nums.length == 0) return nums;
        int start = 0, end = nums.length - 1;
//        start != end &&
        while (start < end) {
            if (nums[start] % 2 == 0 && nums[end] % 2 != 0) {
                swap(nums, start, end);
                start ++;
                end --;
            }
            if (nums[start] % 2 == 0 && nums[end] % 2 == 0) {
                end --;
            }
            if (nums[start] % 2 != 0 && nums[end] % 2 !=0) {
                start ++;
            }
            if (nums[start] % 2 != 0 && nums[end] % 2 ==0) {
                start ++;
                end --;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public int[] exchange_2(int[] nums) {
        if (nums.length == 0) return nums;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 != 0) start++;
            while (start < end && nums[end] % 2 == 0) end--;
            swap(nums, start, end);
        }
        return nums;
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 != 0) start++;
            while (start < end && nums[end] % 2 == 0) end--;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }


}
