package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class offer_55_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    // 递归实现
    public int maxDepth_1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth_1(root.left), maxDepth_1(root.right)) + 1;
    }

    // 非递归实现 层序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 一层有几个元素 队列当前元素个数就是上一层元素的个数
            for (int i = 0; i < size; i++) { // 有几个弹出几个元素 清空队列 往下层进发
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res++; // 一层结束了 高度++

        }
        return res;
    }

}
