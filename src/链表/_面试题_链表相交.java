package 链表;

public class _面试题_链表相交 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode curA = headA,curB = headB;
//        int lenA = LinkListLen(curA);
//        int lenB = LinkListLen(curB);
//        int diff = lenA>=lenB?lenA-lenB:lenB-lenA;
//
//        for (int i = 0; i < diff; i++) {
//            if (lenA>=lenB){
//                curA = curA.next;
//            }else {
//                curB = curB.next;
//            }
//        }
//
//        while (curA!=null&&curB!=null){
//            if (curA.val == curB.val){
//                return curA;
//            }
//            curA = curA.next;
//            curB = curB.next;
//        }
//        return null;
//    }

//    public int LinkListLen(ListNode node){
//        int lenth = 0;
//        while (node!=null){
//            node = node.next;
//            lenth++;
//        }
//        return lenth;
//    }
}
