package 树;

public class LeetCode_543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int maxDepth = Integer.MIN_VALUE;
    // 左子树最大深度+右子树最大深度
    public int diameterOfBinaryTree_1(TreeNode root) {
        if (root == null) return 0;
        // 这个地方我理解错误了，这个地方已经遍历过了
        // 在下面调用depth的时候已经通过DFS遍历过了这个里不用再次调用前序遍历去遍历节点了，
        // 直接在depth里面计算每个left + right 就可以啦
        diameterOfBinaryTree(root.left);
        int left = depth_1(root.left);
        int right = depth_1(root.right);
        if (maxDepth < left + right) {
            maxDepth = left + right;
        }
        diameterOfBinaryTree(root.right);
        return maxDepth;
    }

    // 计算节点深度
    public int depth_1(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return (left > right? left : right) + 1;
    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }





}
