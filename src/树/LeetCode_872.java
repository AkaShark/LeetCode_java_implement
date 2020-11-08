package 树;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);

        int len1 = list1.size();
        int len2 = list2.size();
        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (list1.get(i) == list2.get(i)) {
                    continue;
                }
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

}
