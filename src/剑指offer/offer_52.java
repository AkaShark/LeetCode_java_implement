package 剑指offer;

public class offer_52 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // 思路没问题 但是编码不对！！！
    // 输入两个链表找到他们第一个公共节点
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == headB) return headA;
        ListNode A = headA, B = headB;
        // A 为空的时候变成headB B 为空的时候变成headA 这个样的话交替以下就可以抵消长度差
        while (A != B) {
            if (A == null) {
                A = headB;
            }  else {
                A = A.next;
            }
            if (B == null) {
                B = headA;
            } else {
                B = B.next;
            }
        }
        return A;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode A = headA;
       ListNode B = headB;
       while (A != B) {
           A = A == null? headB: A.next;
           B = B == null? headA: B.next;
       }
       return A;
    }
}
