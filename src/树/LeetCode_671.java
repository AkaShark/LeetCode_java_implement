package 树;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_671 {
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

    // 递归法
    public int findSecondMinimumValue_1(TreeNode root) {
        if (root == null) return -1;
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }

    //
    int res = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return res;
        // 存在子树值不相等，较大值的就可能是第二小的
        if (root.left != null && root.left.val != root.right.val) {
            // 获取左右子树中较大的值
            int bigger = root.left.val > root.right.val ? root.left.val : root.right.val;
            // 如果返回值没有被更改过，bigger可能是第二小的值
            res = res == -1 ? bigger : Math.min(res, bigger);
            // 递归左右子树中值更小的树，递归找到更小的值
            findSecondMinimumValue(root.left.val > root.right.val ? root.right : root.left);
        } else {
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        return res;
    }


}
