package Hot100;

import java.util.*;

public class LeetCode_236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root; // 定义递归出口
        // 后序遍历的过程
        TreeNode left = lowestCommonAncestor_1(root.left, p, q);
        TreeNode right = lowestCommonAncestor_1(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    // 非递归实现 有点难啊 是不是两个栈同时左右开弓啊
    // 找到p q 节点路径
    // 和记录父节点的思路差不多
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack_left = new Stack<>();
        Stack<TreeNode> stack_right = new Stack<>();
        TreeNode node_left = root;
        TreeNode node_right = root;
        TreeNode visited_left = root;
        TreeNode visited_right = root;

        while ((node_left != null || !stack_left.isEmpty()) && node_left != p) {
            while (node_left != null) {
                stack_left.push(node_left);
                node_left = node_left.left;
            }
            node_left = stack_left.peek();
            if (node_left.right == null || node_left.right != visited_left) {
                visited_left = node_left;
                stack_left.pop();
                node_left = null;
            } else {
                node_left = node_left.right;
                stack_left.push(node_left);
            }
        }

        while ((node_right != null || !stack_right.isEmpty()) && node_right != q) {
            while (node_right != null) {
                stack_right.push(node_right);
                node_right = node_right.left;
            }
            node_right = stack_right.peek();
            if (node_right.right == null || node_right.right != visited_right) {
                visited_right = node_right;
                stack_right.pop();
                node_right = null;
            } else {
                node_right = node_right.right;
                stack_left.push(node_right);
            }
        }

        int l = Math.abs(stack_left.size() - stack_right.size());
        if (stack_left.size() > stack_right.size()) {
            while (l > 0) {
                stack_left.pop();
                l --;
            }
        } else {
            while (l > 0) {
                stack_right.pop();
                l --;
            }
        }

        while (stack_left.isEmpty() || stack_right.isEmpty()) {
            if (stack_left.peek() == stack_right.peek()) {
                return stack_left.peek();
            } else {
                stack_left.pop();
                stack_right.pop();
            }
        }
        return null;
    }

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    // 后序遍历 遍历二叉树标记父节点
    public void dfs (TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root); //标记父节点
        while (p != null) {
            visited.add(p.val); // 记录访问过的p的父节点
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) { // 查看有没有已经访问过的节点
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
