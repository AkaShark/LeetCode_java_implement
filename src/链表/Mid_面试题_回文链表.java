package 链表;

public class Mid_面试题_回文链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail_head = reveral(slow);
        while (head!=null){
            System.out.println(head.val);
            if (tail_head.val != head.val) return false;
            tail_head = tail_head.next;
            head = head.next;
        }
        return true;

    }
// 翻转
    private ListNode reveral(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode pre = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
