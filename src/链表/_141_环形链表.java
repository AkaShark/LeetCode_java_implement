package 链表;

public class _141_环形链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode slow) {
        if (slow.next == null) {
            return false;
        }
        ListNode fast = slow.next;
        while (fast != null || slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

}
