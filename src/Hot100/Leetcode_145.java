package Hot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode_145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // 非递归
    public List<Integer> postorderTraversal_1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = root;
        TreeNode node = root;
        List<Integer> ans = new LinkedList<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode top = stack.peek();
            // 如果是叶子节点或者是右节点已经被访问过直接输出
            if (top.right == null || top.right == lastVisited) {
                lastVisited = top;
                ans.add(top.val);
                stack.pop();
            } else {
                node = top;
                node = node.right; // 否则右边的节点并没有访问过 开始转向遍历右节点
            }

        }
        return ans;
    }

    List<Integer> ans = new LinkedList<>();
    // 递归实现
     List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            ans.add(root.val);
        }
        return ans;
    }
}
