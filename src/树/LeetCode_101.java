package 树;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归实现
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror (TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            if (node1.val == node2.val) {
                return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
            }
        }
        return false;
    }


    // 队列实现 广度优先搜索
    public boolean isSymmetric_1 (TreeNode root) {
        return check(root, root);
    }

    public  boolean check(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node1);
        q.offer(node2);
        while (!q.isEmpty()) {
            node1 = q.poll();
            node2 = q.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if ((node1 == null || node2 == null) || (node1.val != node2.val)) {
                return false;
            }
            q.offer(node1.left);
            q.offer(node2.right);

            q.offer(node1.right);
            q.offer(node2.left);
        }
        return true;
    }
}
