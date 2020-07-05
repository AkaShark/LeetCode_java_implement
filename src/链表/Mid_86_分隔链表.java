package 链表;

public class Mid_86_分隔链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //[1,4,3,2,5,2]
//双dummy 一个大于X一个小于X 与奇数偶数的那个题差不多
    public static ListNode partition(ListNode head, int x) {
        ListNode first_dummy = new ListNode(0);
        ListNode second_dummy = new ListNode(0);
        ListNode pre_first = first_dummy, pre_second = second_dummy;
        while (head != null) {
            if (head.val < x) {
                pre_first.next = head;
                pre_first = pre_first.next;
            } else {
                pre_second.next = head;
                pre_second = pre_second.next;
            }
            head = head.next;
        }
        pre_second.next = null;
        pre_first.next = second_dummy.next;
        return first_dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        partition(node, 0);
    }
}
