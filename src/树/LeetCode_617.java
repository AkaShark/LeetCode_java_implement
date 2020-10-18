package 树;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 遍历就完事了
    // DFS
    /*
     * 1. 两棵树对应的节点都为空 合并后的节点为空
     * 2. 其中一个节点为空，另一个节点不为空 合并后的节点为不空的节点
     * 3. 两个节点都不为空 正常合并
     * 整体是一个递归的过程*/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 一个节点为空的情况
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        // 都不为空的情况
        // 创建一个新的根节点
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    // BFS
    public TreeNode mergeTrees_1(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queueT1 = new ArrayDeque<>();
        Queue<TreeNode> queueT2 = new ArrayDeque<>();

        queue.offer(merged);
        queueT1.offer(t1);
        queueT2.offer(t2);

        while (!queueT1.isEmpty() && !queueT2.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode node1 = queueT1.poll();
            TreeNode node2 = queueT2.poll();

            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;

            // 左节点
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queueT1.offer(left1);
                    queueT2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }

            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queueT1.offer(right1);
                    queueT2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }
            }
        }
        return merged;
    }
}
