package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_876 {
    public class ListNode {
        private ListNode next;
        private int value;

        public ListNode(ListNode next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    public ListNode middleNode_1(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.size() % 2 != 0? list.get(list.size() / 2): list.get((list.size() + 1) / 2);
    }

    public ListNode middleNode_2(ListNode head) {
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            cur = cur.next;
            i ++;
        }
        int count = i % 2 != 0? i / 2: (i + 1) / 2;
        cur = head;
        while (count > 0) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
