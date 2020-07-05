package 链表;

public class _面试题_返回倒数第k个节点 {
    public  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
// 翻转 正向求
    public int kthToLast(ListNode head, int k) {
        if(head.next==null){
            return head.val;
        }
        ListNode pre = null,cur = head,temp = head;
        while (cur!=null){
            temp = cur.next;
            cur = pre;
            pre = cur;
            cur = temp;
        }
        for (int i = 0; i < k; i++) {
            pre = pre.next;

        }
        return pre.val;
    }

//    先用一个指针first遍历到第k个节点，然后用另一个指针second从头开始遍历，当first到达最后一个节点时，second就是倒数第k个 利用了中间差K个距离 所以第一个指针到最后的时候第二个指针就到了倒数第K个位置
//    Leetcode
//public int kthToLast(ListNode head, int k) {
//    ListNode first = head;
//    ListNode second = head;
//    for(int i=0; i<k-1; i++){//前移k-1步
//        first = first.next;
//    }
//    while(first.next != null){
//        first = first.next; // 向前移动k步
//        second = second.next;
//    }
//    return second.val;
//}
}
