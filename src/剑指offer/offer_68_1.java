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

    // 优化 减少判断取p q 的最大最小值
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > q.val) { // 保证 p.val < q.val
                TreeNode tmp = p;
                p = q;
                q = tmp;
            }
            while (root != null) {
                if (root.val < p.val) // p,q 都在 root 的右子树中
                    root = root.right; // 遍历至右子节点
                else if (root.val > q.val) // p,q 都在 root 的左子树中
                    root = root.left; // 遍历至左子节点
                else break;
            }
            return root;
    }

    //  递归实现 p q 在左子树 递归左子树 在右子树递归右子树
    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor_3(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor_3(root.left, p, q);
        // 即不在做也不在右 则是结果 直接返回
        return root;
    }


}
