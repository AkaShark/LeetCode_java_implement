package 树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LeetCode_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 深度优先遍历
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int leftDepth = maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
//    }

    // 广度优先遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int depth = 0;
        int size = 0;

        while (!queue.isEmpty()) {
            // 当前这一层的节点数量
            size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
