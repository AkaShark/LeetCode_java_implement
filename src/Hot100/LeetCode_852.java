package Hot100;

public class LeetCode_852 {

    public int peakIndexInMountainArray_1(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return i;
            }
        }
        return arr.length - 1;
    }

   // 二分法解决
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0, right = arr.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) { // left左边都不要了
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
