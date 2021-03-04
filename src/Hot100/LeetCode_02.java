package Hot100;

import com.sun.xml.internal.bind.v2.TODO;

public class LeetCode_02 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 按顺序走就行了
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        int value1 = 0, value2 = 0;
        int flag = 0;
        ListNode dummy = new ListNode(); // 头结点
        ListNode cur = dummy; // 工作指针

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            } else {
                value1 = 0;
            }
            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            } else {
                value2 = 0;
            }

            int sum = value1 + value2 + flag;
            ListNode node = new ListNode();
            node.val = sum % 10;
            node.next = null;

            flag = sum / 10;

            cur.next = node;
            cur = cur.next;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }

    // 求和 翻转
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value1 = 0, value2 = 0;
        int index1 = 0, index2 = 0;

        while (l1 != null) {
            value1 += l1.val * Math.pow(10, index1);
            index1 ++;
            l1 = l1.next;

        }

        while (l2 != null) {
            value2 += l2.val * Math.pow(10, index2);
            index2 ++;
            l2 = l2.next;
        }

        int sum = value1 + value2; // 大数越界了 这个没法解决了

        if (sum == 0) return new ListNode(0);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (sum > 0) {
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            sum = sum / 10;
            cur = cur.next;
        }
        return dummy.next;
    }


    // 迭代
    public ListNode reverseList(ListNode head) {
       if (head == null) return null;
       ListNode pre = null;
       ListNode cur = head;
       while (head != null) {
          ListNode next = cur.next;
          cur.next = pre;
          pre = cur;
          cur = next;
       }
       return pre;
    }

    // 递归
    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList_1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
