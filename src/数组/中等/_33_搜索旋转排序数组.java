package 数组.中等;

public class _33_搜索旋转排序数组 {
//    二分法（二分法的改良）
    public int search(int[] nums, int target) {
//        异常处理
        if (nums.length<=0) return -1;
        if (nums.length == 1) return nums[0] == target?0:-1;
        int len = nums.length,l = 0, r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid] == target) return mid;
//            左边是有序的
            if (nums[0]<=nums[mid]){
//                判断target是是否在这个范围
//                整体是前闭后开的样子
                if (nums[0]<=target&&target<nums[mid]){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                if (nums[mid]<target&&target<=nums[len-1]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }

}
