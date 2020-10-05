package 树;

public class LeetCode_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null) return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null) invert(root.left);
        if (root.right != null) invert(root.right);
    }

    //leetCode
    // 后续遍历 类似于
    public TreeNode invertTree_1(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}
