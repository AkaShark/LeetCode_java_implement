package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class offer_34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    // 前序遍历
    void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        // 叶子节点 并且 路径和sum相同 加入最后的结果list
        if (tar == 0 && root.left == null && root.right == null)
            // 值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
            //正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        // 回溯 如果不对的话 path弹出上一个节点完成回溯的过程
        path.removeLast();
    }
}
