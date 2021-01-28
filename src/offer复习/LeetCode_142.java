package offer复习;

import java.util.HashSet;

public class LeetCode_142 {
/*
* 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
* 如果 pos 是 -1，则在该链表中没有环
*/
    public class ListNode {
        int val;
        ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

    public ListNode detectCycle_1(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else return null;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }

        }
        return null;
    }

    // leetCode
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else return null;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    // HashSet实现
    public ListNode detectCycle_2(ListNode head) {
        if (head == null) return head;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;

    }


}
