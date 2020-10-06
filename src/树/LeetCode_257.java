package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
//    List<String> res = new LinkedList<>();
//    List<TreeNode> nodeList = new LinkedList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        if (root == null) return res;
//        if (root.left == null && root.right == null) {
//            String value = "";
//            for (TreeNode node : nodeList) {
//                value = String.valueOf(node.val);
//                if (node.left != null && node.right != null) {
//                    value += "->";
//                }
//            }
//            res.add(value);
//
//        }
//        if (root.left != null) {
//            nodeList.add(root.left);
//            binaryTreePaths(root.left);
//        }
//        if (root.right != null) {
//            nodeList.add(root.right);
//            nodeList.add(root.right);
//        }
//        return res;
//    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            // 当前节点是叶子节点
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString()); // 添加到答案中
            } else {
                pathSB.append("->"); // 当前节点不是叶子节点
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    // 网友优化的dfs 过程 不用一直toString
    private void dfs(TreeNode root, StringBuilder cur, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(cur.toString() + root.val);
            return;
        }
        int sz = cur.length();
        cur.append(root.val).append("->");
        dfs(root.left, cur, paths);
        dfs(root.right, cur, paths);
        cur.delete(sz, cur.length());
    }

    public List<String> binaryTreePaths_1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new  StringBuffer(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
    }


}
