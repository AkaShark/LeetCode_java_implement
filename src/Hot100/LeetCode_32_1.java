package Hot100;

import java.lang.reflect.Array;
import java.util.*;

public class LeetCode_32_1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int[] levelOrder_1(TreeNode root) {
        if (root == null) return new int[]{};
        if (root.left == null && root.right == null) return new int[]{root.val};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                System.out.println();
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(root.right);
                }
                size --;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> tem = new ArrayList<>();
            tem.add(root.val);
            ans.add(tem);
            return ans;
        }

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(res);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> tem = new ArrayList<>();
            tem.add(root.val);
            ans.add(tem);
            return ans;
        }
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> res = new LinkedList<>(); // 双端队列
            while (size > 0) {
                TreeNode node = queue.poll();
                if (!reverse) {
                    res.addFirst(node.val);
                } else {
                    res.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
                reverse = !reverse;
            }
            ans.add(new LinkedList<>(res));
        }
        return ans;
    }
}
