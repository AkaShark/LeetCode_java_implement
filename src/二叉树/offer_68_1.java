package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class offer_68_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (root != null) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    // 遍历两次 寻找路径
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = getPath(root, p);
        ArrayList<TreeNode> pathQ = getPath(root, q);
        for (int i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if (pathP.get(i) != pathQ.get(i) && i > 0 && i < Math.min(pathP.size(), pathQ.size())) {
                return pathP.get(i - 1);
            }
        }
        return null;
    }

    public ArrayList<TreeNode> getPath(TreeNode root, TreeNode node) {
        ArrayList<TreeNode> list = new ArrayList<>();
        while (root != null) {
            list.add(root);
            if (root.val > node.val) {
                root = root.left;
            } else if (root.val < node.val) {
                root = root.right;
            } else break;
        }
        list.add(root);
        return list;
    }

}
