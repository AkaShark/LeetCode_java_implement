package 链表;

public class 面试题_0204_分割链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//    public ListNode partition(ListNode head, int x) {
//        ListNode bigDummy = new ListNode(0);
//        ListNode smallDummy = new ListNode(0);
//        ListNode cur_big = bigDummy;
//        ListNode cur_small = smallDummy;
//        while (head!=null){
//            ListNode temp = head.next;
//            if (head.val<x){
//                head.next = null;
//                cur_small = cur_small.next = head;
//            }else {
//                bigDummy = cur_big.next = head;
//            }
//            head = temp;
//        }
//        cur_big.next = smallDummy.next;
//        return bigDummy.next;
//    }
    public ListNode partition(ListNode head, int x) {
        ListNode pre = head,cur = head;
        while (cur!=null){
            if (cur.val<x){
                int temp = cur.val;
                cur.val = pre.val;
                pre.val = temp;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

}
