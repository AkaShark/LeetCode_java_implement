package 树;

import java.util.*;

public class LeetCode_653 {
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

    // 空间复杂度O(n) 时间复杂度O(2n)
    // 中序遍历 + 双指针
    List<Integer> list = new LinkedList<>();
    public boolean findTarget_0(TreeNode root, int k) {
        if (root == null) return false;
        dfs(root);
        int start = 0, end = list.size() - 1;
        while (end > start) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) return true;
            else if (sum > k) end--;
            else start++;
        }
        return false;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    // 空间复杂度O(n) 时间复杂度O(n) 将list替换为hashset加快了查找另一个元素的过程
    // HashSet + 遍历二叉树
    public boolean findTarget_1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    // HashSet + 遍历二叉树
    public boolean findTarget_2(TreeNode root, int k) {
        if (root == null) return false;

        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) return true;
            set.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }

    // 我的方法官方的代码 java 对于对象类型的参数传递是引用传递，但是对于值类型的是值传递
    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }




}
