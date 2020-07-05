package 链表;

public class _19_删除链表的倒数第N个节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node,first = head,second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
            pre = pre.next;
        }
        pre.next = second.next;
        return node.next;
    }

////    LeetCode代码 思路差不多 他是没有维护pre 但是间距差了n-1
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode node = new ListNode(-1);
//        node.next = head;
//        ListNode first = node,second = node;
//        // 为了保证n合理
//        for (int i = 1; i <= n+1; i++) {
//            first = first.next;
//        }
//        while (first!=null){
//            first = first.next;
//            second = second.next;
//        }
//        second.next = second.next.next;
//        return node.next;
//    }
}
