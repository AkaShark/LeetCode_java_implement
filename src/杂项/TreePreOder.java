package 杂项;

import java.util.Stack;

public class TreePreOder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 先序遍历 递归
    public void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            visit(root);
            recursionPreorderTraversal(root.left);
            recursionPreorderTraversal(root.right);
        }
    }

    // 非递归实现使用栈
    private void preorderTraversal (TreeNode root) {
        // 栈 暂存
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;

        // 利用栈暂存节点 遍历完左子树后弹栈遍历右子树
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                visit(node);
                stack.push(node);
                node = node.left;
            }

            // 直到左子树为空
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    // 访问节点函数
    public void visit(TreeNode node) {
        System.out.println(node.val);
    }

}
