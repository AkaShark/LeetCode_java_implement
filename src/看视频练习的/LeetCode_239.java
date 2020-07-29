package 看视频练习的;

import java.util.*;

public class LeetCode_239 {
    //    滑动窗口 时间复杂度为O（Nk）暴力法
//    public int[] maxSlidingWindow(int[] nums, int k) {
////        异常
//        int n = nums.length;
//        if (n * k == 0) return new int[0];
//
//        int[] maxValues = new int[n-k+1];
//        for (int i = 0; i < n-k+1; i++) {
//            int[] temp = new int[k];
//            int index = i;
//            for (int j = 0; j < k ; j++,index++) {
//                temp[j] = nums[index];
//            }
//            int max = findMax(temp);
//            maxValues[i] = max;
//        }
//        return maxValues;
//    }
//
//    private int findMax (int[] nums) {
//        int max = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]>=max) {
//                max = nums[i];
//            }
//        }
//        return max;
//    }

    //    优先队列 和第一个差不多都是属于那种暴力解法 O（Nlog(K)）因为在大小为K的堆中插入一个元素消耗log(K)
    //    循环法解决的
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        int n = nums.length;
//        int[] maxNums = new int[n-k+1];
//        for (int i = 0; i < n - k + 1; i++) {
//            int index = i;
//            for (int j = 0; j < k; j++, index++) {
//                maxHeap.add(nums[index]);
//            }
//            maxNums[i] = maxHeap.poll();
//            maxHeap.clear();
//        }
//        return maxNums;
//    }

//    ArrayDeque<Integer> deq = new ArrayDeque<>();
//    int [] nums;
//
////    维护双端队列 i 为当前的元素索引 k 为窗口大小 保证最大的在第一个
//    public void clean_deque(int i, int k) {
////        移出不在滑动窗口的元素 滑动窗口向前移动 i-k大于的话就该移出第一个了
//        if (!deq.isEmpty() && deq.getFirst() == i-k)
//            deq.removeFirst();
////        移出比当前元素小的前面的所有元素 因为前面的元素不可能再成为最大元素了 保留第一个为最大的
//        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
//            deq.removeLast();
//    }
//    // 双端队列 标准解
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        // 异常处理
//        if (n * k == 0) return new int[0];
//        if (k == 1) return nums;
//        // init deque and output
//        this.nums = nums;
//        int max_idx = 0;
//
////        循环窗口大小次 初始化 第一次
//        for (int i = 0; i < k; i++) {
////            维护双端队列
//            clean_deque(i,k);
//            // 添加的是索引
//            deq.addLast(i);
//            // 比较nums[max]和nums[i]的大小
//            if (nums[i] > nums[max_idx]) max_idx = i;
//        }
//        int [] output = new int[n-k+1];
//        output[0] = nums[max_idx];
////        构建output 循环n-k+1
//        for (int i = k; i < n ; i++) {
//            clean_deque(i,k);
//            deq.addLast(i);
//            output[i-k+1] = nums[deq.getFirst()];
//        }
//        return output;
//    }


    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output 前面的k个元素已经处理啦
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }


}
