package 树;

import java.util.*;

public class LeetCode_100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 判断是否是相同的二叉树的话直接遍历就好了吧
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean left = true, right = true;
        if (p != null && q != null) {
            if (p.val == q.val) {
                left = isSameTree(p.left, q.left);
                right = isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else {
            if (p == null && q == null) return true;
            else return false;
        }
        return left && right;
    }

    // 遍历树 两个遍历 超出内存限制！！ 我giao
    public boolean isSameTree_1(TreeNode p, TreeNode q) {
        List<Integer> listp = new ArrayList<>();
        List<Integer> listq = new ArrayList<>();
        Stack<TreeNode> stackp = new Stack<>();
        Stack<TreeNode> stackq = new Stack<>();

        TreeNode nodep = p;
        TreeNode nodeq = q;

        while (nodep != null || !stackp.isEmpty()) {
            while (nodep != null) {
                listp.add(nodep.val);
                stackp.push(nodep);
                nodep = nodeq.left;

            }
            //
            if (!stackp.isEmpty()) {
                nodep = stackp.pop();
                nodep = nodep.right;
            }
        }

        while (nodeq != null || !stackq.isEmpty()) {
            while (nodeq != null) {
                listq.add(nodeq.val);
                stackq.push(nodeq);
                nodeq = nodeq.left;
            }
            if (!stackq.isEmpty()) {
                nodeq = stackq.pop();
                nodeq = nodeq.right;
            }
        }

        return listp == listq;
    }


    // LeetCode方法 深度优先搜索
    // 思路跟我的一样 但是代码比我写的简洁  把最后的需要递归的部分放在最后的部分
    public boolean isSameTree_2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p ==null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree_2(p.left, q.left) && isSameTree_2(p.right, q.right);
        }
    }

    // LeetCode方法 广度优先搜索 层序遍历
    public  boolean isSameTree_3(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            // ^	如果相对应位值相同，则结果为0，否则为1	（A ^ B）得到49，即 0011 0001
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(left2);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}