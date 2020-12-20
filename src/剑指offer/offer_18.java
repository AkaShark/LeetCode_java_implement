package 剑指offer;

public class offer_18 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteNode_1(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                // 值都不相同的话 可以直接返回
                break;
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode deleteNode_2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        // head的val不等于val
        head.next = deleteNode_2(head.next, val);
        return head;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }
}
