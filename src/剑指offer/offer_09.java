package 剑指offer;

import java.util.ArrayDeque;
import java.util.Stack;

public class offer_09 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public offer_09() {


    }

    public void appendTail(int value) {
        this.stack1.push(value);

    }

    public int deleteHead() {
//        if (stack2.isEmpty()) {
//            while (!stack1.isEmpty()){
//                stack2.push(stack1.pop());
//            }
//            if (stack2.isEmpty()) return -1;
//            else return stack2.pop();
//        } else {
//            return stack2.pop();
//        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
