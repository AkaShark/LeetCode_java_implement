package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_116 {
    private class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    // 层序遍历 广度优先
    public Node connect_1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                Node curNode = queue.poll();
                Node nextNode = queue.peek();
                if (count - 1 == 0)
                    nextNode = null;
                curNode.next = nextNode;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                count --;
            }
        }
        return root;
    }

    // 深度优先
    public Node connect(Node root) {
        if (root == null) return root;
        Node leftmost = root; // 从根节点开始
        while (leftmost.left != null) {
            Node head = leftmost; // 遍历这一层节点组成的链表为下一层的节点建立Next
            while (head != null) {
                // step 1
                head.left.next = head.right;
                // step 2
                if (head.next != null) {
                    head.right.next = head.next.left; // 第一个父节点的右孩子指向了第二个父节点的左孩子
                }
                // 对后面节点同样操作 右子树
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
