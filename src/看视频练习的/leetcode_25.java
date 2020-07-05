package 看视频练习的;

public class leetcode_25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end!=null; i++) {
//                end 指向最后要反转的最后一个节点
                end = end.next;
            }
            if (end==null)  break;
//            要反转的下一个
            ListNode next = end.next;
//            开始反转的位置
            ListNode start = pre.next;
            end.next = null;
//            前面连上
            pre.next = reverse(start);
//            start 变到了最后面 连上后面
            start.next = next;
//            更新指针完成下一轮
            pre = start;
            end = pre;

        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
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
