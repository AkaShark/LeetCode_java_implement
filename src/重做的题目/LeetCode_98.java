package 重做的题目;

import java.util.*;

public class LeetCode_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    // 中序遍历(非递归) 升序序列
//    public boolean isValidBST(TreeNode root) {
//        // 栈
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        double inorder = -Double.MAX_VALUE;
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (root.val <= inorder) {
//                return false;
//            }
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;
//    }

//    long inorder = Long.MIN_VALUE;
//    // 中序遍历(递归)
//    public  boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        // 中序遍历
//        if (!isValidBST(root.left)) return false;
//        // visit
//        if (root.val <= inorder) return false;
//
//        inorder = root.val;
//        return isValidBST(root.right);
//    }

    // 也算是递归 但是传递了一个上下界保证不超过这个界限就可以了 递归子树也同样需要符合要求
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        if (!helper(root.left, lower, root.val)) return false;
        if (!helper(root.right, root.val, upper)) return false;
        return true;
    }
}
