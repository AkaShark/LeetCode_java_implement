package 二叉树;

import java.util.HashMap;
import java.util.HashSet;

public class offer_68_2 {
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

    // 返回的是节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null; // 为空的话直接返回空
        if (root == p || root == q) return root; // 如果root等于p或者q的话 则直接返回root 为所求
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 遍历左子树查找
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 遍历右子树查找
        if (left == null && right == null) return null; // 左右都查不到p或者q
        if (left == null) return right;
        if (right == null) return left;
        return root; // 左右不为空 返回当前的root为结果
    }

    TreeNode ans = null;
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    // 后序遍历 返回的是是否存在
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        if ((left && right) || (node == p || node == q) && (left || right)) ans = node;
        return left || right || node.val == p.val || node.val == q.val;
    }


    HashSet<Integer> visited = new HashSet<>();
    HashMap<Integer, TreeNode> parent = new HashMap<>();

    // 创建map 构建节点与其父节点的映射
    public void dfs_2(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs_2(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs_2(root.right);
        }
    }

    // 存储父节点
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        dfs_2(root);
        while (p != null) {
            visited.add(p.val); // 添加到访问set中
            p = parent.get(p.val); // 访问到父节点
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }







}
