package 杂项;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetCode_215 {
    // 排序
    public int findKthLargest_1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 堆
    public int findKthLargest_2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    // 快排 还是有问题 欠思考
     public int  findKthLargest_3(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return -1;
        int index = quickSearch(nums, 0, nums.length - 1, k);
        return nums[index];
    }

     public int quickSearch(int[] nums, int low, int height, int k) {
        int index = partition(nums, low, height);
        if (index == nums.length - k) return index;
        return index > k ? quickSearch(nums, low, index - 1, k) : quickSearch(nums, index + 1, height, k);
    }

     public int partition_1(int[] nums, int low, int height) {
        int v = nums[low]; // 临界值
        int i = low, j = height + 1;
        while (true) {
            while (++i <= height && nums[i] <= v);
            while (--j >= low && nums[j] >= v);
            if (i >= j) break;
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }

        nums[low] = nums[i];
        nums[i] = v;
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                // 在右边部分
                left = index + 1;
            } else if (index > target) {
                // 在左边部分
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int i = left, j = right + 1, pivot = nums[left];
        while (true) {
            while (j >= i && nums[i] < pivot) i ++;
            while (j >= i && nums[j] > pivot) j --;
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return j;

    }


}
