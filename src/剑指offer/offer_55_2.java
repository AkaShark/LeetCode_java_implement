package 剑指offer;

public class offer_55_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /*
    * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
    * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。*/
    // 左子树右子树高度差 中序遍历
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftH = 0, rightH = 0;
        leftH = TreeHeight(root.left);
        rightH = TreeHeight(root.right);
        if (Math.abs(leftH - rightH) > 1) {
            return false;
        }
        isBalanced(root.left);
        isBalanced(root.right);
        return true;
    }

    public int TreeHeight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(TreeHeight(root.left), TreeHeight(root.right)) + 1;
    }
}
