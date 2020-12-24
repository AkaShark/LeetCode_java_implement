package 剑指offer;

public class offer_21 {

    // 类似快排的思想 可以使用函数指针将判断条件换成函数 提高 代码的复用性
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

    // 定义头指针和尾指针 头指针一直往右移直到遇到了偶数 尾指针一直往左移直到预见了奇数 然后swap两个值 重复上述操作知道头指针等于尾指针
    public int[] exchange_3(int[] nums) {
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
    // 快慢指针 快指针搜索奇数的位置，慢指针在后面等待着与快指针做交换
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return nums;
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            // fast指向的是奇数的时候
            if ((nums[fast] & 1) == 1) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow ++;
            }
            fast ++;
        }
        return nums;
    }


}
