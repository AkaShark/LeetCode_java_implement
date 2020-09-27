package 看视频练习的;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    public boolean isValidBST(TreeNode root) {
//        return helper(root, null, null);
//    }
//
//    public boolean helper(TreeNode node, Integer lower, Integer upper) {
//        // 如果节点为null 直接True
//        if (node == null) {
//            return true;
//        }
//        int val = node.val;
//        // val 小于下限
//        if (lower != null && val <= lower) {
//            return false;
//        }
//        // val 大于上限
//        if (upper!=null && val >= upper) {
//            return false;
//        }
//        // 递归调用 右节点  下限为val 上限为upper 只改变一个 upper或者lower都是为null 左无下限右无上限
//        if (!helper(node.right, val, upper)) {
//            return false;
//        }
//        if (!helper(node.left, lower, val)) {
//            return false;
//        }
//        return true;
//    }

    // 中序遍历 非递归
//    public boolean isValidBST(TreeNode root) {
//        // 双端队列
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        double inorder = -Double.MAX_VALUE;
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (root.val <= inorder) {
//                return false;
//            }
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    // 中序遍历 递归
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点 如果当前节点小于等于中序遍历的前一个节点，说明不满足BST 返回flase， 否则继续遍历
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);

    }





}
