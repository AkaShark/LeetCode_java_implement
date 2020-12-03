package 剑指offer;

import java.util.ArrayDeque;
import java.util.Queue;

// 两个队列的方法
public class offer_09_expand {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    /** Initialize your data structure here. */
    public offer_09_expand() {

    }
    /** Push element x onto stack. */
    public void push(int x) {
        // queue2 始终始终未空
        queue2.offer(x);
        // 将队列1全部导入队列2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换下
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        // 将新添加入元素添加到queue2中（queue2始终是一个空的队列） 然后将queue1添加到queue2中年
        // 这样保证了新进来的元素始终在queue1的队头 =》 栈顶
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();

    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

// 使用一个队列的方法 这样的操作的话 算法的空间复杂度更小，减少了一个队列的空间
class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            // 队列的翻转
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
       return queue.isEmpty();
    }
}
