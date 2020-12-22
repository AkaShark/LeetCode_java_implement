package 剑指offer;

public class offer_18_2 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // offer原数上的答案改进+dummy 但是还是有点啰嗦
    public ListNode deleteDuplication_1(ListNode pHead) {
        if (pHead == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode next = null;
        while (pHead != null) {
            next = pHead.next;
            boolean isNeedDelete = false;
            if (next != null && next.val == pHead.val) isNeedDelete = true;
            if (isNeedDelete) {
                int value = next.val;
                ListNode delete_node = pHead;
                while (delete_node != null && delete_node.val == value) {
                    delete_node = delete_node.next;
                }
                pre.next = delete_node;
                pHead = delete_node;
            } else {
                pre = pHead;
                pHead = next;
            }
        }
        return dummy.next;
    }

    // 查看题解 自己优化版本
    public ListNode deleteDuplication_2(ListNode pHead) {
        return null;
    }


    // 递归版本
    public ListNode deleteDuplication(ListNode head) {
        return null;
    }
}
