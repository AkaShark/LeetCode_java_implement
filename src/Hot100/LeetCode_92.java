package Hot100;

import java.rmi.UnexpectedException;

public class LeetCode_92 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/*/
    public ListNode reverseBetween_1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = cur;
        ListNode last = null;
        // 找到left right 前后元素 防止断链
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        last = pre;
        for (int i = 0; i < right - left + 1; i++) {
            last = last.next;
        }

        ListNode leftNode = pre.next;
        ListNode rightNode = last.next;
        // 断开
        pre.next = null;
        last.next = null;

        pre.next = reverse(leftNode, last);
        leftNode.next = rightNode;
        return dummy.next;
    }

    private ListNode reverse(ListNode from, ListNode to) {
        ListNode pre = null;
        while (pre == null || pre != to) {
            ListNode next = from.next;
            from.next = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public ListNode reverseBetween_2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = null;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int curPos = 1;
        ListNode prev = dummy, cur = head;
        for (; curPos < left; curPos++) {
            prev = cur;
            cur = cur.next;
        }

        ListNode pre = prev, tail = cur;
        for (; curPos <= right; curPos ++) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        // 对接上
        tail.next = cur;
        pre.next = prev;

        return dummy.next;
    }



    
}
