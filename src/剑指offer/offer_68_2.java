package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class offer_68_2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, offer_68_1.TreeNode left, offer_68_1.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    TreeNode res = null;
    // 后序遍历 从叶子节点到根节点
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        dfs_1(root, p, q);
        return res;
    }

    public boolean dfs_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (lson || rson) && (root.val == p.val || root.val == q.val)) {
            res = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }


    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    // 构造父节点map
    public void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            dfs(node.right);
        }
    }
}
