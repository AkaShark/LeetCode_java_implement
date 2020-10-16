package 树;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_590 {
    public class Node {
        int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    // 递归实现
    List<Integer> list = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        for (Node node : root.children) {
            postorder(node);
        }
        list.add(root.val);
        return list;
    }


    // 迭代实现
    public List<Integer> postorder_1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);

            // 与前序遍历少了一个reverse的过程
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
