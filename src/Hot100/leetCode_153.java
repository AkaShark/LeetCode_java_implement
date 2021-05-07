package Hot100;

public class leetCode_153 {
    /*
    * 旋转的定义是最后一个元素到第一个的位置 后面的元素依次往后挪一个*/

    // 没那么多B事情的遍历方法
    public int findMin_1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= res) {
                res = nums[i];
            }
        }
        return res;
    }

    // 二分法 利用局部有序的特性
    // 之前的题目是查找 现在要查找的就是有序和无序的分割点 分割点就是最小的元素
    // 二分法的思想就是不停的缩小数据的规模
    // ps: 元素都不相同
    public int findMin_2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[left]) { // 右边有序
                right = mid - 1;
            } else { // 左边有序
                left = mid ;
            }
        }
        int res = (left + 1) >= nums.length ? 0: left + 1;
        return nums[res];

    }

    // 不行垃圾代码 不知道为啥 讲道理剩两个的时候可以判断那个是最小的 也 没准 没准早就错过去了 那就用变量存下！！！
    public int findMin_3(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (right - left != 1) { // 中间只有两个元素的时候
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] > nums[right]? nums[right] : nums[left];

    }

    // 玩赖写法 感觉把走的点都踩一遍保证最小 失去了寻找有序无序起点的那一步
    public int findMin_4(int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int min = Math.min(nums[left], nums[right]);
            res = Math.min(min, res);

            if (nums[mid] < nums[left]) { // 右边有序
                right = mid - 1;
            } else { // 左边有序
                left = mid;
            }

            if (nums[mid] < res) {
                res = nums[mid];
            }
        }
        return res;
    }

    // LeetCode 和我思路是一样的但是编码上完胜 思考细节上多了一笔
    // 思路上是一样的多练习这个中思路
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (high > low) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) { // 右边有序 遗弃
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }


}
