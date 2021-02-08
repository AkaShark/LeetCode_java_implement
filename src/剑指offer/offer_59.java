package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class offer_59 {
    // 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    // 未实现 暴力法未果
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return new int[0];
//        List<Integer> window = new LinkedList<>();
//        List<Integer> res = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < k && j < nums.length; j++) {
//                window.add(nums[j]);
//            }
//
//            int max = window.get(0);
//            for (int j = 0; j < window.size(); j++) {
//                if (window.get(j) > max) {
//                    max = window.get(j);
//                }
//            }
//            res.add(max);
//        }
//        int resInt[] = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            resInt[i] = res.get(i);
//        }
//        return resInt;
//
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }


}
