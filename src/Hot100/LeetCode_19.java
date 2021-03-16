package Hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_19 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 快慢指针
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) return null;
        ListNode dummy = new ListNode(0,head);
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            if (node == null) return null;
            node = node.next;
        }
        ListNode cur = dummy; // 从dummy开始遍历得到的刚好是要删除节点的前一个节点
        while (node != null) {
            node = node.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }

    // 计算链表长度
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;

    }

    public int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            ++l;
            head = head.next;
        }
        return l;
    }

    // 栈实现
    public ListNode removeNthFromEnd_3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy; // 从dummy开始栈顶刚好是pre
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;

        return dummy.next;
    }

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
