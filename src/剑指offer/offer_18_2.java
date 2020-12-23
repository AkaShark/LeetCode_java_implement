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
                // 寻找相同的节点一起删除（往后遍历相同值的节点)
                while (delete_node != null && delete_node.val == value) {
                    delete_node = delete_node.next;
                }
                // 前置节点
                pre.next = delete_node;
                // 当前节点
                pHead = delete_node;
            } else {
                // 前置节点和当前节点一起往前移动一个
                pre = pHead;
                pHead = next;
            }
        }
        return dummy.next;
    }

    // 查看题解 自己优化版本
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode last = dummy.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    // 找到最后一个值相同的节点
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                // 如果不等的话一起向下走
                pre = pre.next;
                last = last.next;
            }
        }
        return dummy.next;
    }


    // 递归版本 递归实现 代码更加简洁
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = null;
        if (head.next.val == head.val) {
            cur = head.next.next;
            while (cur != null && cur.val == head.val) cur = cur.next;
            return deleteDuplication(cur);
        } else {
            cur = head.next;
            head.next = deleteDuplication(cur);
            return head;
        }
    }
}
