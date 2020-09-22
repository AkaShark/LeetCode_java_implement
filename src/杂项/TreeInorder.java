package 杂项;

import java.util.Stack;

public class TreeInorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归实现
    public void recursionMiddleorderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleorderTraversal(root.left);
            visit(root);
            recursionMiddleorderTraversal(root.right);
        }
    }

    // 非递归实现
    public void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            // 左子树入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 弹出左子树  访问左节点
            if (!stack.isEmpty()) {
                node = stack.pop();
                visit(node);
                node = node.right;
            }
        }
    }


    // 访问节点函数
    public void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
