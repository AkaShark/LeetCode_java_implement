package 面试准备;

import java.util.Stack;

public class LeetCode_232 {

    // 双栈实现队列
    // 首先创建两个栈 stack1 和 stack2 其中stack1负责接收元素 stack2 弹出元素
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;
    /** Initialize your data structure here. */
    public LeetCode_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // stack1 负责push
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 弹出的时候分为两种case
        /*
        * 1. 当stack2 为空的时候 将stack1的全部元素导入到stack2中 再弹出Stack2的元素
        * 2. 当stack2 不为空的时候 直接弹出
        * */
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        // peek和 pop 一样
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // 判断两个队列是否都为空 当都为空的时候返回true
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
