package 剑指offer;

import java.util.*;

// 使用一个数组创建一个模拟队列
public class offer_59_2 {
    // 均摊时间复杂度为O(1) 这样的话利用辅助空间
    int queueA[] = new int[20000];
    int begin = 0, end = 0;
//    public MaxQueue() {
//
//    }

    public int max_value() {
        int res = -1;
        for (int i = begin; i != end; i++) {
            res = Math.max(res, queueA[i]);
        }
        return res;
    }

    public void push_back(int value) {
        queueA[end++] = value;
    }

    public int pop_front() {
        if (begin == end) return -1;
        return queueA[begin++];
    }
}


// 维护一个单调的双端队列
class MaxQueue {
    Queue<Integer> queueA;
    Deque<Integer> queueB;

    public MaxQueue() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    public int max_value() {
        if (queueB.isEmpty()) return -1;
        return queueB.peekFirst();
    }

    public void push_back(int value) {
        while (!queueB.isEmpty() && queueB.peekLast() < value) queueB.pollLast(); // 弹出队列中小于value的元素
        queueB.offerLast(value);
        queueA.offer(value);

    }

    public int pop_front() {
        if (queueA.isEmpty()) return -1;
        int ans = queueA.poll();
        if (ans == queueB.peekFirst()) queueB.pollFirst();
        return ans;
    }
}
