package 树;

import java.util.*;

public class LeetCode_107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        if (root == null) return new LinkedList<>();
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        List<List<Integer>> ans = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> list = new LinkedList<>();
//            // 当前这一层
//            while (size > 0) {
//                TreeNode node = queue.poll();
//                list.add(node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//                size--;
//            }
//            ans.add(list);
//        }
//        // 数组翻转
//        Collections.reverse(ans);
//
//        return ans;
//
//    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            // 添加到头部 这样的效率更高
            ans.add(0, level);
        }
        return ans;
    }
}
