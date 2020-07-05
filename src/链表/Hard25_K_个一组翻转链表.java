package 链表;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hard25_K_个一组翻转链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    没难度 主要解决的问题是不要断链 前面留一个 后面留一个中间翻转就行了 我的问题就是有点乱 抓住核心问题
//   static public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy = new ListNode(1);
//        dummy.next = head;
//        ListNode pre = dummy;
//        while (head!=null){
//            ListNode node = head;
//            for (int i = 0; i < k; i++) {
//                if (head==null) return dummy.next;
//                head = head.next;
//            }
//    reverse
//            ListNode temp = null;
//            while (node!=head){
//                ListNode next = node.next;
//                node.next = temp;
//                temp = node;
//                node = next;
//            }
//            pre.next = temp;
//            for (int i = 0; i <k ; i++) {
//                pre = pre.next;
//            }
//            pre.next = head;
//        }
//        return dummy.next;
//    }

//    LeetCode 思路跟我一样 比我好在抓住问题的核心 变量名的设计  主要是防止断开 主要是保留反转部分的前驱以及反转部分的后继
//    public ListNode reverseKGroup(ListNode head, int k) {
//    虚拟头节点
//    ListNode dummy = new ListNode(0);
//    dummy.next = head;
//
//    ListNode pre = dummy;
//    ListNode end = dummy;
//
//    while (end.next != null) {
//    end到要翻转的尾部
//        for (int i = 0; i < k && end != null; i++) end = end.next;
//        if (end == null) break;
//    start到要翻转的头部
//        ListNode start = pre.next;
//    记录要翻转的部分的下一个节点
//        ListNode next = end.next;
//    断开
//        end.next = null;
//    翻转并连接pre到翻转完的部分 连接
//        pre.next = reverse(start);
//      标记新的要翻转的部分 并将翻转完的和后面的部分连接 （start在最后end在前面） 连上后面的部分
//        start.next = next;
//    更新节点
//        pre = start;
//
//        end = pre;
//    }
//    return dummy.next;
//}
//  翻转操作
//private ListNode reverse(ListNode head) {
//    ListNode pre = null;
//    ListNode curr = head;
//    while (curr != null) {
//        ListNode next = curr.next;
//        curr.next = pre;
//        pre = curr;
//        curr = next;
//    }
//    return pre;
//}
//
// LeetCode 递归解法
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode cur = head;
//        int count = 0;
//        while (cur != null && count != k) {
//            cur = cur.next;
//            count++;
//        }
//        if (count == k) {
//            cur = reverseKGroup(cur, k);
//            while (count != 0) {
//                count--;
//                ListNode tmp = head.next;
//                head.next = cur;
//                cur = head;
//                head = tmp;
//            }
//            head = cur;
//        }
//        return head;
//    }

//    LeetCode 利用栈实现
    static public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (true){
            int count = 0;
            ListNode tmp = head;
//            入栈
            while (tmp!=null&&count<k){
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
//            少于K个元素
            if (count!=k){
                pre.next = head;
                break;
            }
            while (!stack.isEmpty()){
                pre.next = stack.pollLast();
                pre = pre.next;
            }
            pre.next = tmp;
            head = tmp;
        }
        return dummy.next;

    }
//    https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-si-wei-ru-he-tiao-chu-xi-jie-by-labuladong/
//    LeetCode 递归

//leetCode 递归 题解写的特好
//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-si-wei-ru-he-tiao-chu-xi-jie-by-labuladong/
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reverseKGroup(node, 2);
    }
}