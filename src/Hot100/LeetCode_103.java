package Hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_103 {
    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new LinkedList<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int levelLen = queue.size();
            while (levelLen >= 0) {
                TreeNode node = queue.poll();
                if (reverse) {
                    // 反向输出
                    list.offerFirst(node.value);
                } else {
                    list.offerLast(node.value);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                levelLen --;
            }
            reverse = !reverse;
            ans.add(new LinkedList<>(list));
        }
        return ans;
    }
}
