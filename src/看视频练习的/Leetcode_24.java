package 看视频练习的;

public class Leetcode_24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //        两两交换
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head!=null && head.next!=null){
            ListNode cur = head, next = head.next;

//            swapping
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

//            review
            pre = cur;
            head = cur.next;
        }
        return dummy.next;
    }
}
