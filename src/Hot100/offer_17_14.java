package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class offer_17_14 {
    /*
    * 时间复杂度比较高的方法O(nlogn)
    * */
    public int[] smallestK_1(int[] arr, int k) {
        if (arr == null || arr.length <= 0) return new int[]{};
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /*
    * 快排思路 快排每次确定一个数字的最终位置
    * 找到第K个
    * 找一个数开始一轮快排
    *   * t == k 找到第k个数 前面的就是最小的第k个元素
    *   * t < k  缩小了问题规模 继续在0-t-1中寻找
    *   * t > k  缩小问题规模 继续在t+l - L 中寻找
    * */
    // 入口
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length < 0) return new int[]{};
        randomizedSeleted(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 决策
    public void randomizedSeleted(int[] arr, int l, int r, int k) {
        if (l >= r) return;
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSeleted(arr, l, pos - 1, k);
        } else {
            randomizedSeleted(arr, pos + 1, r, k - num);
        }

    }

    // 快排入口
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    // 分割
    public int partition(int[] nums, int l, int r) {
        int pivot= nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            // 将小于pivot都已到左边
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    // swap
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
