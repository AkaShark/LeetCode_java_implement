package 剑指offer;

public class offer_18 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 这个题和剑指offer原书上的题目还是略有差异的
    public ListNode deleteNode_1(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.val == val) {
                // 删除head节点
                pre.next = head.next;
                // 值都不相同的话 可以直接返回
                break;
            }
            pre = pre.next;
            head = head.next;
        }
        // 返回虚拟头节点的下一个节点
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

    // 剑指offer原题
    // 原题的难度在于要在O(1)的时间复杂度内解决这个问题，同时需要思考全面仅仅是用下一个节点替换上一个节点的值是不够还需要考虑要删除节点的在于链表的位置（在表尾巴， 表中只有一个节点的情况）
    public void DeleteNode(ListNode head, ListNode toBeDelete) {
        // 要删除的节点或者头节点为空的情况 不做处理直接返回
        if (head == null || toBeDelete == null) return;
        // 要删除的节点不是尾结点 即要删除的节点是很多节点中间的一个节点 (要删除节点不是最后一个节点)
        if (toBeDelete.next != null) {
            // 要删除的节点为next
            ListNode next = toBeDelete.next;
            toBeDelete.val = next.val;
            toBeDelete.next = next.next;
        }

        // 要删除节点是最后一节点 只有一个节点
        if (toBeDelete == head) {
            // 要删除的节点是唯一的节点则 head和toBeDelete均置为空
            head = null;
            toBeDelete = null;
        } else { // 有多个节点 并且要删除的节点在尾结点则需要遍历的到最后一个节点
            ListNode cur = head;
            while (cur.next != toBeDelete) cur = cur.next;
            cur.next = null;
        }
    }

}
