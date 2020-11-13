package 树;

public class LeetCode_965 {
    public class TreeNode{
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

    int temp = 0;
    boolean unival = true;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        temp = root.val;
        dfs(root);
        return unival;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val != temp) {
            unival = false;
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
