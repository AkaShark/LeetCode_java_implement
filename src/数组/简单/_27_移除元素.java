package 数组.简单;


import java.util.Arrays;

public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i++;
    }
//LeetCode 优化

//public int removeElement(int[] nums, int val) {
//    int i = 0;
//    int n = nums.length;
//    while (i < n) {
//        if (nums[i] == val) {
//            nums[i] = nums[n - 1];
//            // reduce array size by one
//            n--;
//        } else {
//            i++;
//        }
//    }
//    return n;
//}


}
