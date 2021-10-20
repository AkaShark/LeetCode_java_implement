package offer复习;

public class LeetCode_21 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(){};

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 迭代实现
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                while (l1 != null) {
                    cur.next = l1;
                    l1 = l1.next;
                }
            } else if (l2 != null) {
                while (l2 != null) {
                    cur.next = l2;
                    l2 = l2.next;
                }
            }
        }
        return dummy.next;
    }

    // 递归实现
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val >= l2.val) {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            } else {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }


}
