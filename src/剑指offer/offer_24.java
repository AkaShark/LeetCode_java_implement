package 剑指offer;

public class offer_24 {
//    纸上得来终觉浅，绝知此事要躬行
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    // 迭代实现
    public ListNode reverseList_1(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 递归实现
    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) return null;
       // 到最后一个节点前将每个节点压入栈中
       ListNode new_head = reverseList(head.next);
       // 第一个head为倒数第二个节点 函数逐层的弹栈head不断的往前回溯
       head.next.next = head;
       // 针对第一个节点 也就是翻转后的最后一个节点
       head.next = null;
       return new_head;
    }

}
