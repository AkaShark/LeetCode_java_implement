package 树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        // List 转数组
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;

    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }

    public void update(int x) {
        if (x == base) {
            count++;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

// Mirror 中序遍历
    public int[] findMode_1(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }


    TreeNode pre = null;
    public void searchBST(TreeNode root) {
        if (root == null) return;

        searchBST(root.left);
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) { // 和前一个值一样
            count++;
        } else {
            count = 1;
        }
        pre = root;
        if (count == maxCount) {
            answer.add(root.val);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(root.val);
        }
        searchBST(root.right);
    }

    public int[] findMode_2(TreeNode root) {
        searchBST(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }





}
