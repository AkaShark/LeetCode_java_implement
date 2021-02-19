package 剑指offer;

import java.util.LinkedList;
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
    // 两次遍历
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        List<TreeNode> listP = new LinkedList<>();
        List<TreeNode> listQ = new LinkedList<>();
        TreeNode node = root;
        // 找p
        while (p != null) {
            listP.add(node);
            if (node.val > p.val) {
                node = node.left;
            } else if (node.val < p.val) {
                node = node.right;
            } else {
                break;
            }
        }
        node = root;
        // 找q
        while (q != null) {
            listQ.add(node);
            if (node.val > q.val) {
                node = node.left;
            } else if (node.val < q.val) {
                node = node.right;
            } else {
                break;
            }
        }

        for (int i = 0, j = 0; i < listP.size() && j < listQ.size(); i++, j++) {
            if (listP.get(i) == listQ.get(j)) {
                node = listP.get(i);
            }
        }
        return node;

    }

    // 遍历一次
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode res = root;
        while (true) {
            if (res.val > p.val && res.val > q.val) {
                res = res.left;
            } else if (res.val < p.val && res.val < q.val) {
                res = res.right;
            } else {
                break;
            }
        }
        return res;
    }


}
