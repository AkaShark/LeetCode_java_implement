package 树;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_897 {
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

    public TreeNode increasingBST_1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode cur = node;
        for (Integer value : list) {
            cur.right = new TreeNode(value);
            cur = cur.right;
        }
        return node.right;

    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    TreeNode cur = null;
    public TreeNode increasingBST(TreeNode root) {
        // dummy
        TreeNode node = new TreeNode(0);
        cur = node;
        inorder(root);
        return node.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = cur.right;
        inorder(node.right);
    }


}
