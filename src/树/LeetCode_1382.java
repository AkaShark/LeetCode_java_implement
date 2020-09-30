package 树;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_1382 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    List<Integer> list = new LinkedList<>();

    // 中序遍历 + 递归调平
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        TreeNode node =  helper(list, 0, list.size() - 1);
        return node;
    }

    public TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, left, mid - 1);
        root.right = helper(list, mid + 1, right);

        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
