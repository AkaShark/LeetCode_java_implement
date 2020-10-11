package 树;

import javafx.util.Pair;

import java.util.*;

public class LeetCode_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    // 思路是对的 编码实现不对
//    int max_depth = 0;
//    public int maxDepth(Node root) {
//        if (root == null) return 0;
//        for (Node node : root.children) {
//            if (node != null) {
//                int depth = maxDepth(node);
//                if (depth > max_depth) max_depth = depth;
//            }
//        }
//        return max_depth+1;
//    }


    // 正确实现方式  DFS
    public int maxDepth(Node root) {
        int max_depth = 0;
        if (root == null) return 0;
        for (Node node : root.children) {
            if (node != null) {
                // 寻找子树中最长的那个
                max_depth = Math.max(max_depth, maxDepth(node));
            }
        }
        return max_depth + 1;
    }

    // 迭代 BFS
    public int maxDepth_1(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 这一层的元素
            while (size > 0) {
                Node queueNode = queue.poll();
                for (Node node : queueNode.children) {
                    if (node != null) {
                        queue.offer(node);
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }

    // LeetCode 答案
    public int maxDepth_2(Node root) {
        if (root == null) return 0;
        else if (root.children.isEmpty()) return 1;
        else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth_2(item));
            }
            return Collections.max(heights) + 1;
        }
    }

    public int maxDepth_3(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) stack.add(new Pair<>(root, 1));

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                for (Node c : root.children) {
                    stack.add(new Pair<>(c, current_depth + 1));
                }
            }
        }
        return depth;
    }
}
