package 杂项;

public class TreeeInorderByMirror {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void inorderMorrisTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        while (cur != null) {
            // 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点
            if (cur.left == null) {
                visit(cur);
                cur = cur.right;

            } else { // 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点
                // 进入左子树中查找
                prev = cur.left;
                //  左子树的最右边的节点是当前节点在中序遍历中的前驱节点
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;
                // 如果前驱节点的右孩子为空，将他的右孩子设置为当前的节点，当前节点更新为当前节点的左孩子
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else { // 如果前驱节点的右孩子为当前节点，将他的右孩子重新设置为空（恢复树的形状）输出当前节点，当前节点更新为当前节点的右孩子
                    prev.right = null;
                    visit(cur);
                    cur = cur.right;
                }
            }
        }
    }

    public void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
