package 看视频练习的;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    private TreeNode ans;
//    // 从叶子往上走的
//    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return false;
//        boolean lson = dfs(root.left, p, q);
//        boolean rson = dfs(root.right, p, q);
//        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
//            ans = root;
//        }
//        return lson || rson || (root.val == p.val || root.val == q.val);
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root, p, q);
//        return ans;
//    }

    // 存储父节点的方法

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            // 左孩子的值 和 当前节点
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            // 存储的是右孩子的值和 当前节点
            parent.put(root.right.val, root);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 将所有的节点存储下 存储的是节点和其左右孩子的节点值
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            // p 变为p的父亲节点
            p = parent.get(p.val);
        }

        while (q != null) {
            // q 为根节点 p为根的左子树或者右子树
            if (visited.contains(q.val)) {
                return q;
            }
            // q变为q的父亲节点
            q = parent.get(q.val);
        }
        return null;
    }


}
