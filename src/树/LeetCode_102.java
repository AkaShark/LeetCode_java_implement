package 树;

import java.util.*;

public class LeetCode_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 获取一层的节点
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(list);
        }

        return ans;
    }
}
