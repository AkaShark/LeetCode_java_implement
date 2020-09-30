package 树;

import java.util.Random;

public class LeetCode_108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper (int[] nums, int left, int right) {
        if (left > right) return null;

        // 总是选择中间节点的左边的节点
        // int mid = (left + right) / 2;
        // 总是选择中间节点的右边的节点
        //  int mid = (left + right + 1) / 2;
        // 选择任意一个中间位置数字作为根节点 加0或者1
        Random rand = new Random();
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid -1 );
        root.right = helper(nums, mid + 1, right);

        return root;
    }



}
