package 树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Offer_54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 时间空间复杂度有点高了 换个方法
//    List<Integer> list = new LinkedList<>();
//    public int kthLargest(TreeNode root, int k) {
//        helper(root);
//        Collections.reverse(list);
//        return list.get(k);
//
//    }
//
//    public void helper(TreeNode node) {
//        if (node == null) return;
//        helper(node.left);
//        list.add(node.val);
//        helper(node.right);
//    }

    // 也不高。。。
//    List<Integer> list = new LinkedList<>();
//
//    public int kthLargest(TreeNode root, int k) {
//        helper(root);
//        return list.get(list.size() - k);
//
//    }
//
//    public void helper(TreeNode node) {
//        if (node == null) return;
//        helper(node.left);
//        list.add(node.val);
//        helper(node.right);
//    }

    // LeetCode
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return this.res;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        helper(node.right);
        if (k == 0) return;
        if (--k == 0) res = node.val;
        helper(node.left);
    }

}
