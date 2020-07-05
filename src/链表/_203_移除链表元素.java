package 链表;


public class _203_移除链表元素 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    val的位置
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
//            异常情况
            if (head == null) {
                return null;
            }
            ListNode cur = head, pre = head;
            while (cur!=null){
                if (cur.val==val){
//                    第一个节点
                    if (pre==cur){
                        head = cur.next;
                        pre = head;
                    }else{
                        pre.next = cur.next;
                    }
                }else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return head;
        }
    }
}
//// LeetCode 解决添加头节点将所有节点的操作统一 最后返回头结点的next
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode tempHead = new ListNode(0);
//        tempHead.next = head;
//        ListNode prev = tempHead;
//        while (head != null) {
//            if (head.val == val) {
//                prev.next = head.next;
//            } else {
//                prev = prev.next;
//            }
//            head = head.next;
//        }
//        return tempHead.next;
//    }
