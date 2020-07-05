package 链表;

import java.util.ArrayList;
import java.util.HashMap;

public class Mid_209_长度最小的子数组 {
//    双指针滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
//        获取数组的长度
        int length = nums.length;
        if (length == 0) return 0; // 如果长度为0 则没有匹配的子数组 返回0
//        初始化变量 left 为窗口的左边 right为窗口的右 minSize为最终的结果
        int left = 0,right = 0,sum = 0,minSize = Integer.MAX_VALUE;
//        如果右边小于长度的话
        while (right<length){
//            计和 右边扩展
            sum+=nums[right++];
//            当满足条件的时候
            while (sum>=s){
//                先获取最短长度
                minSize = Math.min(minSize,right-left);
//                左边向前走
                sum -= nums[left++];
            }
        }
//      处理长度
        return minSize==Integer.MAX_VALUE?0:minSize;
    }

}
