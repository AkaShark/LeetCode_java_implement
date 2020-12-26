package 剑指offer;

import java.util.Stack;

public class offer_30 {
// 没有AC
//    Stack<Integer> stack = null;
//    Stack<Integer> minStack = null;
//    int min = Integer.MAX_VALUE;
//
//    public offer_30() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    public void push(int x) {
//        if (x <= min) {
//            min = x;
//            minStack.push(x);
//        }
//        stack.push(x);
//    }
//
//    public void pop() {
//        if (stack.pop().equals(minStack.peek())) {
//            minStack.pop();
//            if (!minStack.isEmpty())
//                min = minStack.peek();
//        }
//
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        if (!minStack.isEmpty())
//            return minStack.peek();
//        return min;
//    }
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> A = null;
    Stack<Integer> B = null;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x) B.push(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek())) B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}



}
