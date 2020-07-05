package 数组.简单;

public class _26_删除排序数组中的重复项 {
    //    双指针
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        for (j = 0; j < nums.length; j++) {
            if (nums[i] !=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
