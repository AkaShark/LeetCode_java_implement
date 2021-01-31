package offer复习;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric_1(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    // 迭代实现
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode headA = root, headB = root;
        queue.offer(headA);
        queue.offer(headB);
        while (!queue.isEmpty()) {
            headA = queue.poll();
            headB = queue.poll();
            if (headA == null && headB == null) continue;
            if ((headA == null || headB == null) || (headA.val != headB.val)) return false;
            // 分开的情况 分别入队列
            queue.offer(headA.left);
            queue.offer(headB.right);

            queue.offer(headA.right);
            queue.offer(headB.left);

        }
        return true;
    }
}
