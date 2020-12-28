package 剑指offer;

import java.util.*;

public class offer_32_2 {
    public class TreeNode {
        int  val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder_1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // queue 使用LinkedList更加快速 效率更高
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 结果
        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            // same level
            int queueLen = queue.size();
            List<Integer> list = new ArrayList<>();
            while (queueLen > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                queueLen --;

            }
            res.add(list);
        }

        return res;

    }


    // leetcode版本 思路差不多但是代码更加简洁
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 一层的元素
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}
