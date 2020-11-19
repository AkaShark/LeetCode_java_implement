package 树;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_1530 {
    public class TreeNode{
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

    private int distance = 0;
    private int count = 0;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        List<Integer> list = traverse(root, 0);
        return count;
    }
    public List<Integer> traverse(TreeNode root, int depth) {
        if (root == null) {
            return new LinkedList<>();
        }

        // 是叶子节点直接返回
        LinkedList<Integer> r1 = new LinkedList<>();
        if (root.left == null && root.right == null) {
            r1.add(depth);
            return r1;
        }

        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();

        if (root.left != null)
            left = traverse(root.left, depth+1);

        if (root.right != null)
            right = traverse(root.right, depth+1);

        // 左右子树有一个没有，就不用计算了 直接返回
        if (left.size() == 0)
            return right;
        if (right.size() == 0)
            return left;

        // 计算左右子树符合distance的对数
        for (int i = 0; i < left.size(); i++) {
            int a = left.get(i);
            for (int j = 0; j < right.size(); j++) {
                int b = right.get(j);
                if ((a - depth) + (b - depth) <= distance) {
                    count++;
                }
            }
        }

        for (int i = 0; i < left.size(); i++) {
            r1.add(left.get(i));
        }
        for (int i = 0; i < right.size(); i++) {
            r1.add(right.get(i));
        }
        return r1;

    }

}
