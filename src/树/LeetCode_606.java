package 树;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LeetCode_606 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    StringBuilder sb = new StringBuilder();
    /*
    如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上一层括号；
    如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
    如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号
    如果当前节点只有右孩子，那我们在递归时，需要先加上一层空的括号 () 表示左孩子为空，再对右孩子进行递归，并在结果外加上一层括号
     */
//    public String tree2str(TreeNode t) {
//        if (t.left == null && t.right == null) return sb.toString();
//        // 只有左孩子
//        if (t.left != null && t.right == null) {
//            sb.append("(").append(t.left.val);
//            tree2str(t.left);
//        }
//        // 只有右孩子
//        if (t.right != null && t.left == null) {
//            sb.append(")");
//            sb.append("()").append("(").append(t.right.val);
//            tree2str(t.right);
//        }
//
//        return sb.toString();
//    }


    public String tree2str(TreeNode t) {
        if (t == null) return "";

        // 左子树和右子树都为空
        if (t.left == null && t.right == null) {
            return t.val + "";
        }

        // 右子树为空 左子树不为空
        if (t.right == null) return t.val + "("+tree2str(t.left)+")";

        // 左右子树都不为空的情况 基本情况
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    public String tree2str_1(TreeNode t) {
        if (t == null) return "";
        String ans = "" + t.val;
        String left = tree2str_1(t.left);
        String right = tree2str_1(t.right);
        if (left.equals("") && right.equals("")) {
            return ans;
        }
        ans = ans + "(" + left + ")";
        if (!right.equals("")) {
            ans += "(" + right + ")";
        }
        return ans;
    }


    // BFS 实现
    public String tree2str_BFS(TreeNode t) {
        if (t == null)
            return "";
        Stack< TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set< TreeNode > visited = new HashSet< >();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

}
