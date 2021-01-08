package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class offer_35 {

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    // 本题难点： 在复制链表的过程中构建新链表各节点的 random 引用指向。

    // 设置hash建立函数映射关系
    // 利用hash表的查询特点，考虑原链表节点 和 新链表节点映射关系，再遍历构建新链表各个节点的next和random引用指向就OK了

    public Node copyRandomList_1(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            // 建立映射key是原节点 value是复制的新节点
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // map获取映射 建立复制节点的next 和 random 引用信息
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新的头结点
        return map.get(head);

    }

    // 复制链表 关键点是random指针的复制
    // 复制节点 拆分链表
    // 原节点后面紧跟着一个复制的节点 时间复杂度为O(n) 空间复杂度为O(1) 原地操作
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 复制各个节点
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;

        // 构建各个新节点的random
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            // 一次移动两步 跳过复制的节点
            cur = cur.next.next;
        }
        // 拆分链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 原链表的表尾原本是指向的最后一个节点的复制节点 拆分开开后要设置为null

        return res;
    }
}
