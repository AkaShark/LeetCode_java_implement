package 链表;

public class Mid_328_奇偶链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) return head;
        ListNode odd_dummy = new ListNode(0);
        ListNode even_dummy = new ListNode(0);
        ListNode odd_cur = head,even_cur = head.next;
        odd_dummy.next = odd_cur;
        even_dummy.next = even_cur;
        while (head!=null&&odd_cur!=null&&even_cur!=null){
            odd_cur =  odd_cur.next = odd_cur.next.next;
            even_cur = even_cur.next = even_cur.next.next;
        }
        odd_cur.next = even_dummy.next;
        return odd_dummy.next;
    }

// LeetCode  没有使用头结点
//    public ListNode oddEvenList(ListNode head) {
//        if (head == null) return null;
//        ListNode odd = head, even = head.next, evenHead = even;
//        while (even != null && even.next != null) {
//            odd.next = even.next;
//            odd = odd.next;
//            even.next = odd.next;
//            even = even.next;
//        }
//        odd.next = evenHead;
//        return head;
//    }
//
}
