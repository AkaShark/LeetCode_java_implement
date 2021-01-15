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
    static public int  findKthLargest(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return -1;
        int index = quickSearch(nums, 0, nums.length - 1, k);
        return nums[index];
    }

    static public int quickSearch(int[] nums, int low, int height, int k) {
        int index = partition(nums, low, height);
        if (index == nums.length - k) return index;
        return index > k ? quickSearch(nums, low, index - 1, k) : quickSearch(nums, index + 1, height, k);
    }

    static public int partition(int[] nums, int low, int height) {
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

    public static void main(String[] args) {
//        [3,2,1,5,6,4]
        int[] arr = new int[]{3,2,1,5,6,4};
       int res =  findKthLargest(arr, 2);
        System.out.println(res);

    }

}
