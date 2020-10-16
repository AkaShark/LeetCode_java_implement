package 树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_589 {
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
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return list;
    }

    // 迭代实现
    public List<Integer> preorder_1(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }

}

