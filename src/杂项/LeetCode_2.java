package 杂项;

public class LeetCode_2 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 自己写的 感觉有点没法 可以优化 参考 LeetCode 答案
    public ListNode addTwoNumbers_0(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int flag = 0;

        while (l1 != null && l2 != null) {
            ListNode node;
            int sum = l1.val + l2.val;
            if (sum / 10 > 0) {
                System.out.println(sum % 10 + flag);
                node = new ListNode(sum % 10 + flag);
                flag = 1;
            } else {
                System.out.println(sum);
                node = new ListNode(sum + flag);
                flag = 0;
            }

            cur.next = node;
            cur = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode node;
            if ((l1.val + flag) / 10 > 0) {
                node = new ListNode((l1.val + flag) % 10);
                flag = 1;
            } else {
                node = new ListNode(l1.val + flag);
                flag = 0;
            }
            cur.next = node;
            cur = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node;
            if ((l2.val + flag) / 10 > 0) {
                node = new ListNode((l2.val + flag) % 10);
                flag = 1;
            } else {
                node = new ListNode(l2.val + flag);
                flag = 0;
            }
            cur.next = node;
            cur = node;
            l2 = l2.next;
        }

        if (flag == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
            cur = node;
        }

        return dummy.next;
    }


    // LeetCode 更加简洁 小细节很多
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


}
