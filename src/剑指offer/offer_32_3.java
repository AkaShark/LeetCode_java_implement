package 剑指offer;

import java.util.*;

public class offer_32_3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();


        while (!queue.isEmpty()) {
            int levealNum = queue.size();
            List<Integer> temp = new ArrayList<>();
            // 同一行
            while (levealNum > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                levealNum --;
            }

            if (index % 2 != 0) {
                // 翻转添加
                temp = reverse(temp);
            }

            res.add(temp);
            index ++;
        }

        return res;
    }

    public List<Integer> reverse(List<Integer> array) {
        List<Integer> res = new ArrayList<>();
        for (int i = array.size(); i > 0 ; i--) {
            res.add(array.get(i));
        }
        return res;
    }
}
