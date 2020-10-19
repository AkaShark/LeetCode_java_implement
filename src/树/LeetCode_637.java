package 树;

import javax.print.Doc;
import java.util.*;

public class LeetCode_637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // 每层的节点个数
            double temp = size; // 标记下
            double sum = 0;
            while (size > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            double ava = sum / temp;
            res.add(ava);
        }
        return res;
    }


    // DFS
    public List<Double> averageOfLevels_1(TreeNode root) {
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }


    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) return;
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val); // 转成double类型
            counts.add(1);
        }

        // 每循环一层的话level + 1
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}
