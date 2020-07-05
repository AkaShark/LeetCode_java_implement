package 链表;

public class _面试题_两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = LinkListLen(curA);
        int lenB = LinkListLen(curB);
        int diff = lenA >= lenB ? lenA - lenB : lenB - lenA;

        for (int i = 0; i < diff; i++) {
            if (lenA >= lenB) {
                curA = curA.next;
            } else {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {  // 这里判断交点不是判断节点的值是否相等是判断节点的地址（引用是否相等）
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public int LinkListLen(ListNode node) {
        int lenth = 0;
        while (node != null) {
            node = node.next;
            lenth++;
        }
        return lenth;
    }

    //   LeetCode---1 交叉节点 长度差
//    https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode node1 = headA;
//        ListNode node2 = headB;
//        while (node1!=node2){ // 如果没有交点则node1==node2==null
//            node1 = node1 != null?node1.next : headB;
//            node2 = node2 != null?node2.next : headA;
//        }
//        return node1;
//    }


//    LeetCode---2  也是利用长度差 和我的差不多 但是是在一个方法内实现的
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//    异常判断
//        if (headA == null || headB == null)
//            return null;
//        ListNode A = headA;
//        ListNode B = headB;
//    A B 向前走
//        while (A != null && B != null) {
//            A = A.next;
//            B = B.next;
//        }
//    下面的只会执行其中的一个
//        while (A != null) {
//            A = A.next;
//            headA = headA.next;
//        }
//        while (B != null) {
//            B = B.next;
//            headB = headB.next;
//        }
//    headA 和 headB 同位置
//        while (headA != null && headB != null) {
//            if (headA == headB) return headA;
//            headA = headA.next;
//            headB = headB.next;
//        }
//        return null;
//    }

}
