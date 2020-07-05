package 链表;

public class _面试题_删除链表的节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        while (head!=null){
            if (head.val==val){
                pre.next = head.next;
            }
            pre = head;
            head = head.next;
        }
        return node.next;
    }
}
