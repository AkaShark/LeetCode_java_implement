package 链表;

public class Mid_24_两两交换链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

// 迭代
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode node = new ListNode(0);
//        node.next = head;
//        ListNode pre = node;
//        while (pre != null && pre.next != null) {
//            ListNode first = pre.next, second = first.next;
//            if (second==null){
//                return node.next;
//            }
//            pre.next = second;
//            first.next = second.next;
//            second.next = first;
//            pre = first;
//        }
//        return node.next;
//    }

    // 递归 这个方法的功能是交换节点
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode first = head,second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
//    LeetCode 的迭代 比我的好 清晰更加
//    public ListNode swapPairs(ListNode head) {
//
//        // Dummy node acts as the prevNode for the head node
//        // of the list and hence stores pointer to the head node.
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//
//        ListNode prevNode = dummy;
//
//        while ((head != null) && (head.next != null)) {
//
//            // Nodes to be swapped
//            ListNode firstNode = head;
//            ListNode secondNode = head.next;
//
//            // Swapping
//            prevNode.next = secondNode;
//            firstNode.next = secondNode.next;
//            secondNode.next = firstNode;
//
//            // Reinitializing the head and prevNode for next swap
//            prevNode = firstNode;
//            head = firstNode.next; // jump
//        }
//
//        // Return the new head node.
//        return dummy.next;
//    }
}
