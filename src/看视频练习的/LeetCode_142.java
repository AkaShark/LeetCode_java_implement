package 看视频练习的;

public class LeetCode_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true){
            if (fast==null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head, slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast){
//                break;
//            }
//        }
//        if (fast == null || fast.next == null) return null;
//        fast = head;
//        while (fast!=slow) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//    已经有环了不可能是没有环的入口 一定不是null
//        return slow;
//    }
}
