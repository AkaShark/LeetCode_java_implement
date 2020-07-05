package 链表;

public class _234_回文链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    class Solution {
        public boolean isPalindrome(ListNode head) {
//            特殊情况
            if (head==null||head.next==null) return true;

//            快慢指针 快指针指向了最后一个节点，慢指针指向中间节点(奇数偶数)
            ListNode fast= head,slow = head;
            while (fast!=null&&fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

            }

            ListNode newHead = null;
            ListNode cur = slow;
//            翻转后半部分的链表
            while(cur!=null){
                ListNode temp = cur.next;
                cur.next= newHead;
                newHead = cur;
                cur = temp;
            }

            while (newHead!=null&&head!=null){
                if (newHead.val!=head.val) return false;
                newHead = newHead.next;
                head = head.next;
            }
//            忽略奇数个的多一个的情况
            return true;

        }
    }
}
