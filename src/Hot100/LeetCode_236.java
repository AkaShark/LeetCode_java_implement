package Hot100;

public class LeetCode_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root; // 定义递归出口
        // 后序遍历的过程
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
