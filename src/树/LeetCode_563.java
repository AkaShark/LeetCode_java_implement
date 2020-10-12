package 树;

import apple.laf.JRSUIUtils;

public class LeetCode_563 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 思路不错但是编码问题
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    public int helper_1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int temp = 0;
        int left = 0, right = 0;
        if (root.left == null) {
            left = 0;
        } else {
            left = helper_1(root.left);
        }
        if (root.right == null) {
            right = 0;
        } else {
            right = helper_1(root.right);
        }
        temp = Math.abs(left - right);
        sum += temp;
        return temp;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum += Math.abs(left - right);

        return left + right + root.val;
    }





}
