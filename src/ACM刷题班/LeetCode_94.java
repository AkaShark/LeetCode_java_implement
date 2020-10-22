package ACM刷题班;

import java.util.*;

public class LeetCode_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归实现
    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal_1(TreeNode root) {
        if (root == null) return res;
        inorderTraversal_1(root.left);
        res.add(root.val);
        inorderTraversal_1(root.right);
        return res;
    }

    // 非递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}
