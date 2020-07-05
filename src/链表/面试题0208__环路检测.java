package 链表;

public class 面试题0208__环路检测 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode detectCycle(ListNode head) {

            ListNode fast = head,slow = head;
            while (true){
                if (fast==null || fast.next == null) return null;
                fast = fast.next.next;
                slow = slow.next;
               if (fast==slow) break;
            }
            slow = head;
            while (slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
    }
}
