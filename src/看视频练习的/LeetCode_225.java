package 看视频练习的;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_225 {
//    /** Initialize your data structure here. */
//    LinkedList<Integer> queue1 = null;
//    LinkedList<Integer> queue2 = null;
//    public  MyStack() {
//        LinkedList<Integer> queue1 = new LinkedList<>();
//        LinkedList<Integer> queue2 = new LinkedList<>();
//
//
//    }
//    public int sSize() {
//        return queue1.size()+queue2.size();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        queue1.addLast(x);
//    }
////    从非空中出队列n-1个到另一个队列 因为duil
//    public void putN_1ToAnthor() {
//        if (!queue1.isEmpty()){
//            while (queue1.size()>1){
//                queue2.addLast(queue1.removeFirst());
//            }
//        } else if (!queue2.isEmpty()) {
//            while (queue2.size()>1) {
//                queue1.addLast(queue2.removeFirst());
//            }
//        }
//    }
//
//    /** Removes the element on top of the stack and returns that element. 两个队列模仿栈的pop FILO 让队列中的前n-1个元素进入另一个队列，然后这个队列就省一个元素，然后让他出去，再循环这个过程 */
//    public int pop() {
//        if (sSize()!=0) {
//            if (!queue1.isEmpty()) { // q1 不为空
//                putN_1ToAnthor();
//                return queue1.removeFirst();
//            } else { // q2 不为空
//                putN_1ToAnthor();
//                return queue2.removeFirst();
//            }
//        } else {
//            return -1;
//        }
//    }
//
//    /** Get the top element. */
//    public int top() {
//        if (sSize()!=0) {
//            if (!queue1.isEmpty()) { // q1 不为空
//                putN_1ToAnthor();
//                return queue1.peek();
//            } else { // q2 不为空
//                putN_1ToAnthor();
//                return queue2.peek();
//            }
//        } else {
//            return -1;
//        }
//
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue1.isEmpty() && queue2.isEmpty();
//    }
Queue<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(list.poll());
        }
        return list.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(list.poll());
        }
        int res = list.poll();
        list.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.peek() == null ? true : false;
    }


}
