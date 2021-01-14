package 剑指offer;

import java.util.*;

public class offer_40 {
    /*
    1. 找出最小的k个数
     */
    // 排序 时间复杂度高
    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = new LinkedList<>();
        if (arr == null || arr.length == 0) return null;
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }

        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    // 排序优化
    public int[] getLeastNumbers_1(int[] arr, int k) {
        if (arr == null || arr.length == 0) return null;
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    //
    // 排序优化 堆维护
    // 大顶堆 遇见小的就替换 把大的都取代了剩下的堆中就是最小的k个
    public int[] getLeastNumbers_2(int[] arr, int k) {
        int[] vec = new int [k];
        if (k == 0) // 排除取0的情况
            return vec;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 从大到小 大顶堆
                return o2 - o1;
            }
        });
        // 进去k个
        for (int i = 0; i < k; i++) {
            // 将前k个数放入大顶堆
            queue.offer(arr[i]);
        }

        // 将剩下的元素添加进去 k + 1
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;
    }

    // 快排思想
    public int[] getLeastNumbers_3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        // 最后一个参数表示我们要找的是下表为k-1的数 （第k小的数）
        return quickSearch(arr, 0, arr.length - 1, k -1);
    }

    public int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每次快排切分1次，找到排序后下表为j的元素，如果j恰好等于k就返回j以及j左边所有的数
        int j = partition(nums, lo, hi);
        if (j == k) return Arrays.copyOf(nums, j + 1);
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段
        // 快排j返回的就是当前元素在数组中的实际位置
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);

    }
    // 快排切分 返回下标j, 使得比nums[j] 小的数都在j的左边，比nums[j]大的数都在j的右边
    public int partition(int[] nums, int lo, int hi) {
        // 9,4,6,8,3,10,4,6
        // 9,4,6,8,3,6,4,10
        //
        int v = nums[lo]; // 临界值
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) break;
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }

        nums[lo] = nums[i];
        nums[i] = v;
        return j;
    }


}
