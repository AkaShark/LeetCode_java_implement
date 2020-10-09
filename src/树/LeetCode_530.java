package 树;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    int minDiff = Integer.MAX_VALUE;
    int preVal = 0;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;

        getMinimumDifference(root.left);

        // 中序遍历
        if (minDiff == Integer.MAX_VALUE) { // 第一次
            preVal = root.val;
        } else {
            if (minDiff >= Math.abs(root.val - preVal)) {
                minDiff = Math.abs(root.val - preVal);
            }
            preVal = root.val;
        }
        getMinimumDifference(root.right);

        return minDiff;
    }

}
