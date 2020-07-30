package 杂项;

import java.util.Stack;

public class LeetCode_155 {
//    class MinStack {
////        两种方法 ：第一种push的时候x满足小于最小栈的peek的时候插入最小栈 不满足的时候将最小栈的peek插入栈 保证全部数字的栈和最小栈的个数保持一致
////                ：第二种是在push的时候判断是否满足小于最小栈的peek满足的话插入不满足的话不做变化 但是在pop的时候判断是否全部数字的栈和最小栈的peek相同如果相同的话将小栈的top也pop
//        // 第一种 保证栈中元素个数一致 实现同步的话更加容易
//        Stack<Integer> allNumStack = null;
//        Stack<Integer> minNumStack = null;
//        /** initialize your data structure here. */
//        public MinStack() {
//            allNumStack = new Stack<>();
//            minNumStack = new Stack<>();
//        }
//
//        public void push(int x) {
////            如果为空或者栈顶元素大于插入的值
//            if (minNumStack.isEmpty() || minNumStack.peek() >= x ) {
//                minNumStack.add(x);
//            } else {
//                minNumStack.push(minNumStack.peek());
//            }
//            allNumStack.add(x);
//        }
//        // 弹栈操作需要让两个栈同步
//        public void pop() {
//           minNumStack.pop();
//           allNumStack.pop();
//        }
//
//        public int top() {
//            return allNumStack.peek();
//        }
//
//        public int getMin() {
//
////            可能这个minStack为空 但是输入假设合理
//            return minNumStack.peek();
//        }
//    }

    class MinStack {
        // 第二种 在pop的时候判断 保证两个栈的同步
        /** initialize your data structure here. */
        Stack<Integer> allNumStack = null;
        Stack<Integer> minNumStack = null;
        public MinStack() {
            allNumStack = new Stack<>();
            minNumStack = new Stack<>();
        }

        public void push(int x) {
//            如果为空或者栈顶元素大于插入的值
            if (minNumStack.isEmpty() || minNumStack.peek() >= x ) {
                minNumStack.add(x);
            }
            allNumStack.add(x);
        }

        public void pop() {
            // 先将这个转成int
            int temp = allNumStack.pop();
            if (temp == minNumStack.peek()) {
                minNumStack.pop();
            }
            allNumStack.pop();
        }

        public int top() {
            return allNumStack.peek();
        }

        public int getMin() {
            return minNumStack.peek();
        }
    }
    //https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/ 解释
    // 往栈push进一个数组 时间复杂度空间复杂度不变
//    class MinStack {
//public:
//    /** initialize your data structure here. */
//    MinStack() {
//    }
//
//    void push(int x) {
//        if (st.size() == 0) {
//            st.push({x, x});
//        } else {
//            st.push({x, min(x, st.top().second)});
//        }
//    }
//
//    void pop() {
//        st.pop();
//    }
//
//    int top() {
//        return st.top().first;
//    }
//
//    int getMin() {
//        return st.top().second;
//    }
//private:
//    stack<pair<int, int>> st;
//};
//

}
