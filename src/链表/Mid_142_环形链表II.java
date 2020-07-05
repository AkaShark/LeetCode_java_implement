package 链表;

import java.util.HashSet;

public class Mid_142_环形链表II {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
//        空间复杂度不是最优的
//        if (head==null) return null;
//        HashSet<ListNode> set = new HashSet<>();
//        while (head!=null){
//            if (set.contains(head)){
//                return head;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return head;


        Boolean first = true;
//        快慢指针法
        if (head == null) return null;
        ListNode temp = head;
        ListNode fast = temp, slow = temp;
        while (first || fast != slow) {
            if (fast == null || fast.next == null) return null;
            first = false;
            fast = fast.next.next;
            slow = slow.next;
        }
        while (temp != slow) {
            slow = slow.next;
            temp = temp.next;
        }
        return temp;

    }

//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head, slow = head;
//        while (true) {
//            if (fast == null || fast.next == null) return null;
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == slow) break;
//        }
//        slow = head;
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return fast;
//    }

//    private ListNode getIntersect(ListNode head) {
//        ListNode tortoise = head;
//        ListNode hare = head;
//
//        // A fast pointer will either loop around a cycle and meet the slow
//        // pointer or reach the `null` at the end of a non-cyclic list.
//        while (hare != null && hare.next != null) {
//            tortoise = tortoise.next;
//            hare = hare.next.next;
//            if (tortoise == hare) {
//                return tortoise;
//            }
//        }
//
//        return null;
//    }

//    https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
//    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
    // If there is a cycle, the fast/slow pointers will intersect at some
    // node. Otherwise, there is no cycle, so we cannot find an e***ance to
    // a cycle.
//        ListNode intersect = getIntersect(head);
//        if (intersect == null) {
//            return null;
//        }

    // To find the e***ance to the cycle, we have two pointers traverse at
    // the same speed -- one from the front of the list, and the other from
    // the point of intersection.
//        ListNode ptr1 = head;
//        ListNode ptr2 = intersect;
//        while (ptr1 != ptr2) {
//            ptr1 = ptr1.next;
//            ptr2 = ptr2.next;
//        }
//
//        return ptr1;
//    }

}
