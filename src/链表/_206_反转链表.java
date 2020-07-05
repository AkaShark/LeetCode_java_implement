package 链表;

public class _206_反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        //        递归
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null ) {
//                return head;
//            }
//            ListNode newHead = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return newHead;
//        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;

            }
            ListNode node = null, temp = head.next;
            while (head != null) {
                head.next = node;
                node = head;
                head = temp;
                temp = temp.next;
            }

            return node;
        }

//        Leetcode答案

//        public ListNode reverseList(ListNode curr) {
//            ListNode prev = null;
//            ListNode next = null;
//            while (curr != null) {
//                next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//            return prev;
//        }

    }
}
