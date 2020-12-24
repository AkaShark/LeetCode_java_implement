package 剑指offer;

public class offer_26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*
    * 思路:
    * 判断B是否是A的子结构需要完成以下两步工作
    * 1. 先遍历A找到和B根节点对应的值开始后续遍历
    * 2. 找到各节点后 遍历A的子树是否和B是匹配的
    *
    * 第一步:
    * 1. 当A或者B为空的时候直接返回false
    * 2. 返回以下三种情况的与
    *   1. A的根节点为根的树包含B
    *   2. A的左子树为根节点的树包含B
    *   3. A的右子树为根节点的树包含B
    * 实质上是对A先做先序遍历
    *
    * 第二步
    * 1. 当节点B为空的时候 返回true 访问到了叶子节点证明全部匹配了
    * 2. 当节点A为空时候 超过了A的叶子节点， B还没有为空 则不匹配
    * 3. 当节点A和节点B的值不相同时候， 返回false 不匹配
    * */
    public boolean isSubStructure(TreeNode A, TreeNode B) { // 前序遍历
        if (A == null || B == null) return false;
        // 前序遍历
        boolean res = subStructure(A, B);
        if (res) return true;
        if (A.left != null) {
            res = isSubStructure(A.left, B);
            if (res) return true;
        }
        if (A.right != null) {
            res = isSubStructure(A.right, B);
            if (res) return true;
        }
        return false;

    }

    public boolean subStructure(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return subStructure(A.left, B.left) && subStructure(A.right, B.right);
    }



    // LeetCode 根左右 前序遍历
    public boolean isSubStructure_1(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false; // 当A，B为空的时候直接返回false
        // 判断B是否是A的子结构 或者 B是否是A.left的子结构 或者B是否是A.right的子结构
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断B是否是A的子结构
    public boolean recur(TreeNode A, TreeNode B) {
        // B 为空的话 访问到了子节点 返回true
        if (B == null) return true;
        // 当A等于空或者A的值不等于B的值的时候返回false
        if (A == null || A.val != B.val) return false;
        // 递归判断A的左子树 A的右子树是否相等
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
