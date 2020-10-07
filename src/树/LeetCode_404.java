package 树;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

//    static int sum = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//
//        helper(root, sum);
//        return sum;
//    }
//
//    public void helper(TreeNode root, int sum){
//        if (root == null) return;
//        if (root.left != null) {
//            if (isLeaf(root.left)) {
//                sum += root.left.val;
//            } else {
//                helper(root.left, sum);
//            }
//        }
//        if (root.right != null) {
//            helper(root.right, sum);
//        }
//
//    }
//
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves_1(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        if (root.left != null) {
            if (isLeaf(root.left)) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves_1(root.left);
            }
        }
        if (root.right != null) {
            res += sumOfLeftLeaves_1(root.right);
        }
        return res;
    }


    public int sumOfLeftLeaves(TreeNode root){
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    sum += node.left.val;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

}
