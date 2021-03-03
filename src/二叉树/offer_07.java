package 二叉树;

import java.util.HashMap;

public class offer_07 {
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

    // 和想法一样的代码实现
    HashMap<Integer, Integer> map = new HashMap<>();
    // 思路
    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // 中序遍历的hash映射
        }
        return recure(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    // 递归调用的过程
    public TreeNode recure(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int pre_root = preLeft; // 前序遍历的第一个节点就是根节点
        int in_root = map.get(preorder[pre_root]); // 获取根节点在中序序列中的位置
        int size_sub = in_root - inLeft; // 计算子树的节点个数

        TreeNode root = new TreeNode(preorder[pre_root]); // 构建根节点
        // 递归左子树
        root.left = recure(preorder, inorder, preLeft + 1, preLeft + size_sub, inLeft, in_root - 1);
        // 递归右子树
        root.right = recure(preorder, inorder, preLeft + size_sub + 1, preRight, in_root + 1, inRight);

        return root;
    }

    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] preorder;
    // 另一种解法思路同上
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i); // 建立中序序列的映射表 方便查找个节点的索引值
        }
        return recursion(0, 0, inorder.length - 1);

    }
    /**
    * @Description: 递归
    * @Param: 根节点在前序序列中的索引 中序序列中的左和右
    * @return: 树的根节点
    * @Author: Sharker
    * @Date: 2021/3/3
    */
    public TreeNode recursion(int root, int left, int right) {
        if (left > right) return null; // 超过叶子节点
        TreeNode node = new TreeNode(preorder[root]); // 构建各节点
        int index = dic.get(preorder[root]); // 获取根节点在中序遍历中的索引
        int sub_size = index - left; // 获取左子树的元素个数
        node.left = recursion(root + 1, left, index - 1); // 遍历左子树
        node.right = recursion(root + sub_size + 1, index + 1, right);
        return node;
    }

}
