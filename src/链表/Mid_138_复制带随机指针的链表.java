package 链表;

public class Mid_138_复制带随机指针的链表 {
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
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node cur = head;
        while (cur!=null){
            Node temp = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur!=null){
           cur.next.random = cur.random == null?null:cur.random.next;
           cur = cur.next.next;
        }
        cur = head;
        Node cloneHead = head.next;
        while (cur.next!=null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return cloneHead;
    }

}
