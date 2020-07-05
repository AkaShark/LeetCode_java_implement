package 看视频练习的;

import java.util.Stack;

// 必须用两个栈了 不跟栈实现队列一样阿！
class MyQueue {
    /**
     * Initialize your data structure here.
     */
//    Stack<Integer> stack1;
//    Stack<Integer> stack2;
//    public MyQueue() {
//        stack1 = new Stack<>();
//        stack1 = new Stack<>();
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        stack1.push(x);
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        while (stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        int popInteger = stack2.pop();
//        while (stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//        return popInteger;
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        while (stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        int popInteger = stack2.peek();
//        while (stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//        return popInteger;
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return stack1.isEmpty();
//    }

//    我的pop和peek操作不是很帅 我这个想当于倒水
//    LeetCode的答案 采用了设置一个是输入栈一个是输出栈


    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}
