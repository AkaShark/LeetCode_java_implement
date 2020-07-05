package 链表;

public class _876_链表的中间结点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode middleNode(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}
