package 链表;

import java.util.HashMap;
import java.util.Map;

public class Mid_面试题35_复杂链表的复制 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
//  我这样不对是深度赋值要求就是要连random也赋值 不能带原来的引用
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        Node dummy = new Node(0);
//        Node pre = dummy;
//        Node work = head;
//        int len = 0;
//        while (work != null) {
//            Node temp = new Node(work.val);
//            temp.next = work.next;
//            pre.next = temp;
//            pre = pre.next;
//            work = work.next;
//            len++;
//        }
//        pre = dummy.next;
//        for (int i = 0; i < len; i++) {
//            pre.random = head.random;
//            pre = pre.next;
//            head = head.next;
//        }
//
//
//        return dummy.next;
//    }

    //  空间复杂度为O(N)
//    public Node copyRandomList(Node head) {
//        if (head==null) return null;
////        map中是源节点和拷贝的节点
//        Map<Node,Node> map = new HashMap<>();
//        for (Node cur = head;cur!=null;cur = cur.next){
//            map.put(cur,new Node(cur.val));
//        }
////      将拷贝的节点组成一个链表 get方法获得的是复制的节点 没用之前的引用 Key Value
//        for (Node cur = head;cur!=null;cur = cur.next){
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//        }
//        return map.get(head);
//    }

//    原地算法 O(1)
    public Node copyRandomList(Node head) {
        if (head==null) return null;
//        完成链表节点的复制 将复制的节点放在原来节点的后面
        Node cur = head;
        while (cur!=null){
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
//      完成链表复制节点的random复制
        cur = head;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
//        拆分
        Node copyHead = head.next;
        cur = head;
        Node curCopy = head.next;
        while (cur!=null){
//            跳过了复制的节点 恢复到原链表的样子
            cur.next = cur.next.next;
            cur = cur.next;
//            复制的节点是隔一个的
            if (curCopy.next!=null){
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return copyHead;
    }


}
