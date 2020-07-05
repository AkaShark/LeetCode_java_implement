package 链表;

public class Mid_143_重排链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        head = dummy.next;
//      这里可以优化 用快慢指针找中间的节点
        int temp_len = len / 2;
        while (temp_len > 0) {
            head = head.next;
            temp_len--;
        }
        ListNode tail_next = head.next;
        head.next = null;
        head = dummy.next;

        ListNode tail = null;
        while (tail_next != null) {
            ListNode temp = tail_next.next;
            tail_next.next = tail;
            tail = tail_next;
            tail_next = temp;
        }

        while (head != null && tail!=null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = tail.next;
            head.next.next = temp;
            head = temp;
        }
    }
//    LeetCode参考的不考虑空间复杂度的话可以使用栈或者双端队列
//
//    LeetCode 思路和我一样但是更加清晰
//    通过观察，可以将重排链表分解为以下三个步骤：
//    首先重新排列后，链表的中心节点会变为最后一个节点。所以需要先找到链表的中心节点：876. 链表的中间结点
//    可以按照中心节点将原始链表划分为左右两个链表。
//    2.1. 按照中心节点将原始链表划分为左右两个链表，左链表：1->2->3 右链表：4->5。
//    2.2. 将右链表反转，就正好是重排链表交换的顺序，右链表反转：5->4。反转链表：206. 反转链表
//    合并两个链表，将右链表插入到左链表，即可重新排列成：1->5->2->4->3.
//https://leetcode-cn.com/problems/reorder-list/solution/3ge-bu-zou-jian-dan-yi-dong-by-wang_dong/

}
