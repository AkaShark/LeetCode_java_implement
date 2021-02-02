package 剑指offer;

import java.util.*;

public class offer_55_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    // 递归实现
    public int maxDepth_1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        // 树的深度就是左右子树深度的最大值 + 1 +1 是root这一层的深度
        return Math.max(maxDepth_1(root.left), maxDepth_1(root.right)) + 1;
    }

    // 非递归实现 层序遍历
    public int maxDepth_2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 一层有几个元素 队列当前元素个数就是上一层元素的个数
            for (int i = 0; i < size; i++) { // 有几个弹出几个元素 清空队列 往下层进发
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res++; // 一层结束了 高度++

        }
        return res;
    }

    // leetCode 非递归实现
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 使用LinkedList模拟队列
        List<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            // 创建临时队列添加下一层的节点
            tmp = new LinkedList<>();
            // 遍历这层的节点
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            // 将下层节点赋值给queue
            queue = tmp;
            res ++; // 标记器++ 完成一层的遍历标签器++
            // 我在处理这个地方的思路差不多我是使用了一个int size标识 来记录当前queue的size 同时这个size就是
            // 上层节点的个数 遍历完这层节点后 标签器++  遍历结束的标志是循环size次
            // 同时在遍历的时候将下层节点添加到queue中相当于没有使用临时的队列
        }
        return res;
    }

    // PS: 注意在使用队列的时候JDK 推荐是使用 Deque
    // Deque<TreeNode> queue = new ArrayDeque<>();


}
