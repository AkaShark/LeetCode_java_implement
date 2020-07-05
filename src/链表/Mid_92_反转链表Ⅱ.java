package 链表;

public class Mid_92_反转链表Ⅱ {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    写的乱 没有节奏 代码写的怪 不优美
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head;
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head,start = head,end,next;
        for (int i = 1; i <n ; i++) {
            if (m-1==0){
                pre = dummy;
                start = pre.next;

            }
            if (i==m-1){
                pre = head;
                start = pre.next;
            }
            head = head.next;
        }
        end = head;
        next = end.next;
        ListNode node =null,tem_next;
        while (start!=next){
            tem_next = start.next;
            start.next = node;
            node = start;
            start = tem_next;
        }
        pre.next = node;
        while (pre!=null) pre=pre.next;
        pre.next = start;
        return dummy.next;
    }
//    LeetCode思路很好 https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/

}
