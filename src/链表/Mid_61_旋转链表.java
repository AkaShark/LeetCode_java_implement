package 链表;

public class Mid_61_旋转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 思路不对
//    static public ListNode rotateRight(ListNode head, int k) {
////        长度
//        int len = linkListLen(head);
//        ListNode tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
////        循环链表
//        tail.next = head;
////        工作指针
//        ListNode node = head;
////        开始移动
//        for (int i = 0; i < len - 1; i++) {
//            ListNode temp = node;
//            for (int j = 0; j < k; j++) {
//                temp = temp.next;
//            }
////            交换值
//            int temValue = temp.val;
//            temp.val = node.val;
//            node.val = temValue;
////            node向下走
//            node = node.next;
//        }
////        变成单链表
//        tail.next = null;
//        return head;
//    }
//
//    static private int linkListLen(ListNode head) {
//        int len = 0;
//        while (head != null) {
//            head = head.next;
//            len++;
//        }
//        return len;
//    }

//    O(n) 时间复杂度对。。。。。我傻了
//    public ListNode rotateRight(ListNode head, int k) {
////        判断老是写还是写错了 那有条件中断的啊
//        if (head==null||head.next==null) return head;
//        ListNode node = new ListNode(0);
//        node.next = head;
//        ListNode pre = node;
//        for (int i = 0; i < k; i++) {
//            ListNode tail = pre.next;
//            while (tail.next.next!=null){
//                tail = tail.next;
//            }
//            pre.next = tail.next;
//            pre.next.next = head;
//            tail.next = null;
//            head = pre.next;
//        }
//        return node.next;
//    }

//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null || head.next == null) return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode first = head, slow = head;
//        k = k > linkListLen(head) ?  k % linkListLen(head)  : k;
//        if (k<=0) return dummy.next;
//        for (int i = 0; i < k; i++) {
//            if (first.next==null) return dummy.next;
//            first = first.next;
//        }
//        while (first.next != null) {
//            first = first.next;
//            slow = slow.next;
//        }
//        ListNode node = slow.next;
//        dummy.next = node;
//        first.next = head;
//        slow.next = null;
//        return dummy.next;
//    }
//
//    private int linkListLen(ListNode head) {
//        int len = 0;
//        while (head != null) {
//            head = head.next;
//            len++;
//        }
//        return len;
//    }


// leetcode 方法 极度舒适
//    思路:https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/
// 先成环保证不会断开，再找到新的头尾断开链表返回新的斗节点

    public ListNode rotateRight(ListNode head, int k) {
        if (head ==null || head.next==null) return head;
        int len ;
        ListNode old_tail = head;
//        成环
        for (len = 0; old_tail.next!=null ; len++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        ListNode new_tail = head;
//        找新的头结点 判断哪里是考虑了k大于len的情况 使用了取模操作
        for (int i = 0; i < len - k % len - 1; i++) {
            new_tail = new_tail.next;
        }
//        新的头结点
        ListNode new_head = new_tail.next;
//        断开
        new_tail.next = null;
        return new_head;
    }
}
