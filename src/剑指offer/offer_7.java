package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class offer_7 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // bad case
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            // 将中序遍历的节点值和下表建立对应关系
            indexMap.put(inorder[i], i);
        }
        // 根节点 传入 前序序列 前序开始的位置 结束的位置， 中序序列开始位置和结束位置，中序序列map对应关系
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        // 递归终止条件 前序序列开始大于结束，没有节点了
        if (preorderStart > preorderEnd) return null;
        // 根节点值 前序序列的第一个节点
        int rootVal = preorder[preorderStart];
        // 构建节点
        TreeNode root = new TreeNode(rootVal);
        // 只有一个节点 返回root
        if (preorderStart == preorderEnd) return root;
        else {
            // 多个节点
            // 获得到根节点在中序序列的index
            int rootIndex = indexMap.get(rootVal);
            // 左子树的个数就是 根节点的位置减去前序开始的位置，右子树的个数就是前序结束的位置到根节点的位置
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            // 构建左子树 新的根节点已经创建所以前序序列个数+1
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            // 构建右子树
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            // 左右子树赋值
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
            // PS 从中序序列获取左右子树节点个数
        }
    }
}
