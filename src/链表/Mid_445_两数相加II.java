package 链表;

import java.util.Stack;

public class Mid_445_两数相加II {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int isCarry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || isCarry > 0) {
            int num1 = 0, num2 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop().intValue();
            }
            if (!stack2.isEmpty()) {
                num2 = stack2.pop().intValue();
            }
            cur = cur.next = new ListNode((num1 + num2 + isCarry) % 10);
            isCarry = (num1 + num2 + isCarry) / 10;
        }
//        上面直接用头插法可以优化 这个还要再去翻转下
        cur = dummy.next;
        ListNode pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

//    LeetCode 女孩子写的代码都是甜甜的 很简介
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//        while (l1 != null) {
//            stack1.push(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            stack2.push(l2.val);
//            l2 = l2.next;
//        }
//
//        int carry = 0;
//    头插法
//        ListNode head = null;
//        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
//            int sum = carry;
//    三目
//            sum += stack1.isEmpty()? 0: stack1.pop();
//            sum += stack2.isEmpty()? 0: stack2.pop();
//            ListNode node = new ListNode(sum % 10);
//    头插法
//            node.next = head;
//            head = node;
//            carry = sum / 10;
//        }
//        return head;
//    }

}
