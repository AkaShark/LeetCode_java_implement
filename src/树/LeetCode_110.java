package 树;

public class LeetCode_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 自顶向下
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        // 判断当前节点的左子树右子树的高度差是否为1 并且 递归判断当前节点的左右子树
//        else return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//
//    }
//
//    // 返回当前节点到叶子节点的高度
//    public int height(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            return Math.max(height(root.left), height(root.right)) + 1;
//        }
//    }

    // 自低向上
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) >= 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }


}
