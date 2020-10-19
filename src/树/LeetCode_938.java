package 树;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode_938 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int sum = 0;

    public int rangeSumBST_1(TreeNode root, int L, int R) {
        if (root == null) return sum;
        if (L <= root.val && root.val <= R) {
            sum += root.val;
        }
        rangeSumBST_1(root.left, L, R);
        rangeSumBST_1(root.right, L, R);
        return sum;
    }


    // 因为题目说是二叉搜索树 可以利用中序遍历 然后通过LR过滤一些值 减少便利的次数
    // 二叉搜索树 根节点大于左子树 小于右子树
    // 时间复杂度低了很多啊
    public int rangeSumBST_2(TreeNode root, int L, int R) {
        if (root == null) return sum;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        // 根节点如果小于L的话 左子树没有比L大的了 不用遍历了
        if (root.val > L) {
            rangeSumBST_2(root.left, L, R);
        }
        // 同理
        if (root.val < R) {
            rangeSumBST_2(root.right, L, R);
        }
        return sum;
    }


    // 迭代实现
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L<= node.val && node.val<=R) {
                    ans += node.val;
                }
                if (L < node.val) {
                    stack.push(node.left);
                }
                if (R > node.val) {
                    stack.push(node.right);
                }
            }
        }
     return ans;
    }
}

