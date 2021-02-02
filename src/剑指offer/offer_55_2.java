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
    // 左子树右子树高度差 先序遍历(这个只需要遍历树就可以了 不一定是先序遍历)
    boolean flag = true;
    public boolean isBalanced_1(TreeNode root) {
        if (root == null) return true;
        int leftH = 0, rightH = 0;
        leftH = TreeHeight(root.left); // 左子树的高度
        rightH = TreeHeight(root.right); // 右子树的高度
        if (Math.abs(leftH - rightH) > 1) { // 高度差是否超过1
            flag = false;
        }
        isBalanced_1(root.left); // 遍历左子树
        isBalanced_1(root.right); // 遍历右子树
        return flag;
    }
    // 获取子树的高度
    public int TreeHeight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(TreeHeight(root.left), TreeHeight(root.right)) + 1;
    }

    // LeetCode

    // 后序遍历 + 剪枝 (从低至顶)
    public boolean isBalanced_2(TreeNode root) {
        // 最后返回的是树的深度
        return recur(root) != -1; // 返回当recur不为 -1的时候返回返回true 否则返回false
    }
    // 后序遍历
    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return  -1; // 剪枝操作 如果高度返回为-1 直接返回上一层
        int right = recur(root.right);
        if (right == -1) return -1;
        // 如果不满足平衡二叉树的条件的话返回 -1 如果满足的话返回当前树的深度 一层一层的往上返回根节点
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1: -1;
    }

    // (遍历树)先序遍历 + 判断深度 (从顶到底 但是会产生重复计算)
    public  boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }



}
