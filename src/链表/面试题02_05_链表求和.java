package 链表;

public class 面试题02_05_链表求和 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//  思路简单 逻辑也很简单 就是顺着写 但是一边聊天一边写慢了 主要逻辑做了注释
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
////        声明一个虚拟头结点方便操作
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
////        标记是否进位
//        boolean isCarry = false;
//        while (l1 != null && l2 != null) {
//            int temp = 0;
//            if (isCarry) {
//                isCarry = false;
//                temp = 1;
//            }
//            temp += l1.val + l2.val;
//            if (temp / 10 > 0) {
//                isCarry = true;
//                temp %= 10;
//            }
//            cur.next = new ListNode(temp);
//            cur = cur.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
////        l1 或者 l2 不为空
//        while (l1 != null) {
//            int temp = l1.val;
//            if (isCarry) {
//                isCarry = false;
//                temp += 1;
//            }
//            if (temp / 10 > 0) {
//                cur.next = new ListNode(temp % 10);
//                isCarry = true;
//            } else {
//                cur.next = new ListNode(temp);
//            }
//            cur = cur.next;
//            l1 = l1.next;
//        }
//
//
//        while (l2 != null) {
//            int temp = l2.val;
//            if (isCarry) {
//                isCarry = false;
//                temp += 1;
//            }
//            if (temp / 10 > 0) {
//                cur.next = new ListNode(temp % 10);
//                isCarry = true;
//            } else {
//                cur.next = new ListNode(temp);
//            }
//            cur = cur.next;
//            l2 = l2.next;
//        }
////        判断是否还存在进位
//        if (isCarry) {
//            cur.next = new ListNode(1);
//        }
//        return dummy.next;
//    }


    //    优化代码结构
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        声明一个虚拟头结点方便操作
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
//        标记是否进位
        boolean isCarry = false;
        while (l1 != null || l2 != null) {
            int num1 = 0, num2 = 0;
            if (l1 == null) {
                num1 = 0;
            }else {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null){
                num2 = 0;
            }else {
                num2 = l2.val;
                l2 = l2.next;
            }
            int temp = num1 + num2;
            if (isCarry) {
                isCarry = false;
                temp += 1;
            }
            if (temp / 10 > 0) {
                isCarry = true;
                temp %= 10;
            }
            cur.next = new ListNode(temp);
            cur = cur.next;
        }
//        判断是否还存在进位
        if (isCarry) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }


//    LeetCode 简约更加 没有判断进位 直接用个int代表了
//class Solution:
//    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
//    head = ListNode(0)
//    node = head
//            remaining = 0
//        while l1 or l2:
//            if l1 == None:
//    node.next = l2
//            l1 = ListNode(0)
//            if l2 == None:
//    node.next = l1
//            l2 = ListNode(0)
//    remaining += l1.val + l2.val
//    node.next = ListNode(remaining % 10)
//    remaining = remaining // 10
//            node = node.next
//    l1 = l1.next
//            l2 = l2.next
//        if remaining:
//    node.next = ListNode(remaining)
//        return head.next

//    LeetCode
//    简约写法 像这个学习很简约 最后一个判断也放在了一起写成一个循环
//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//            ListNode p1 = l1, p2 = l2, result = new ListNode(0);
//            ListNode p = result;
//            int carr = 0;
//
//            while(p1 != null || p2 != null || carr > 0)
//            {
//                int sum = carr;
//                sum += p1 == null ? 0 : p1.val;
//                sum += p2 == null ? 0 : p2.val;
//
//                p.next = new ListNode(sum % 10);
//                p = p.next;
//
//                carr = sum / 10;
//
//                if(p1 != null)
//                    p1 = p1.next;
//                if(p2 != null)
//                    p2 = p2.next;
//            }
//
//            return result.next;
//
//        }
}
