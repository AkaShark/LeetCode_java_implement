package 剑指offer;

public class offer_36 {
    // 搜索二叉树 双向循环链表 有序的
    // 树的节点的左指针指向前序 右指针指向后继
    public class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    // 搜索二叉树的中序遍历的结果是一个序数列
    /*
    * 1. 排序链表 从小到大访问 中序遍历
    * 2. 双向链表 pre.right = cur cur.left = pre
    * 3. 循环链表 head 和 tail 也要相互指向 中序遍历完后 最后一个节点为tail*/
    Node pre = null, head = new Node(0);
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);
        // pre 变为尾结点 head是头结点
        pre.right = head;
        head.left = pre;
        return  head;
    }

    public void recur(Node node) {
        if (node == null) return;
        recur(node.left);
        // pre == null 访问的节点是第一个节点
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        recur(node.right);
    }

}
