package 树;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 自己写的递归实现 代码不够漂亮 参考下面的递归实现
    int flag = 0;
    public boolean hasPathSum_0(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, sum) >= 1;
    }

    public int helper(TreeNode root, int num) {
        if (root == null) return flag;
        if (root.val == num && root.left == null && root.right == null) flag ++;
        if (root.left != null) helper(root.left,num - root.val);
        if (root.right != null) helper(root.right, num - root.val);
        return flag;
    }

    // LeetCode BFS
    // 广度优先遍历 层寻遍历
    public boolean hasPathSum_1(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode now = queueNode.poll();
            int temp = queueValue.poll();
            // 当前节点为叶子节点
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queueNode.offer(now.left);
                queueValue.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queueNode.offer(now.right);
                queueValue.offer(now.right.val + temp);
            }
        }
        return false;
    }

    // 递归实现 DFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // || 或者 只要有一个满足就可以了
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
