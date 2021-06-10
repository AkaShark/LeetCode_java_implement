package 杂项;

import java.util.Stack;

public class TreeLastOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归实现
    public void recursionPostorderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostorderTraversal(root.left);
            recursionPostorderTraversal(root.right);
            visit(root);
        }
    }

    // 非递归实现
    public void postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) { // 开始先遍历左节点
                stack.push(node);
                node = node.left;
            }
            // 查看当前栈顶元素
            node = stack.peek();
            // 如果其右子树也为空, 或者右子树已经访问了 直接输出
            if (node.right == null || node.right == lastVisit) {
                visit(node);
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                // 否则 继续遍历右子树
                node = node.right;
            }

        }
    }

    // 访问节点函数
    public void visit(TreeNode node) {
        System.out.println(node.val);
    }

}
