package 数组.中等;

public class _11_盛最多水的容器 {
    //    时间复杂度高
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int temp = (j-i) * Math.min(height[i],height[j]);
//
//                if (temp>max) max = temp;
//            }
//        }
//        return max;
//    }
// 思路不对 riht可能在后面left还在前面（嗨就是说找不到正确的范围）[1,2,1]
//    public int maxArea(int[] height) {
//        int left = 0,right = 1,max = (right-left) * Math.min(height[left],height[right]);
//        for (int i = 0; i < height.length; i++,right++) {
//            if (height[i]>height[left]){
//                left = i;
//            }
//            int temp = (right-left) * Math.min(height[left],height[right]);
//            if (temp>max) max = temp;
//        }
//        return max;
//    }
    
//    LeetCode看的往中间加 我上面的方法改进这么改就对了
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i<j){
            int h = Math.min(height[i],height[j]);
            res = Math.max(res,h*(j-i));
            if (height[i]<height[j]) i++;
            else j--;
        }
        return res;
    }


}
