package 链表;

import java.util.HashSet;
import java.util.Set;

public class _面试题_移除重复节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
// 时间复杂度过高
        public static ListNode removeDuplicateNodes(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode node = head;
        while (node!=null){
            ListNode pre = node;
            ListNode temp = node.next;
            while (temp!=null) {
                if (node.val == temp.val) {
                    pre.next = temp.next;
                    temp = pre.next;
                }else {
                    pre = temp;
                    temp = temp.next;
                }
            }

            node = node.next;
        }
        return head;
    }
////  leetcode
//    public static ListNode removeDuplicateNodes(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        Set<Integer> numSet = new HashSet<>();
//        while (cur != null) {
//            int num = cur.val;
//            if (numSet.contains(num)) {
//                if (pre != null) { // 第一个节点 多余
//                    pre.next = cur.next;
//                    cur = pre;
//                }
//            } else {
//                numSet.add(num);
//            }
//            pre = cur;
//            cur = cur.next;
//        }
//        pre = null;
//        cur = null;
//        return head;
//    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(2);
        node1.next.next.next.next.next = new ListNode(1);
        removeDuplicateNodes(node1);

    }
}
