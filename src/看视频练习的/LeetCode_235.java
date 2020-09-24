package 看视频练习的;

public class LeetCode_235 {

    /*
    BST 性质
    节点N 左子树上所有的节点的值都小于等于节点N的值
    节点N 右子树上所有的节点的值都大于等于节点N的值
    左子树右子树都是BST
    */

    //  利用了BST的性质
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        // 根节点值
//        int parentVal = root.val;
//        // p节点的值
//        int pVal = p.val;
//        // q节点的值
//        int qVal = q.val;
//        // 都在右子树上
//        if (pVal > parentVal && qVal > parentVal) {
//            return lowestCommonAncestor(root.right, p, q);
//        } else if (pVal < parentVal && qVal < parentVal) {  // 都在左子树上
//            return lowestCommonAncestor(root.left, p, q);
//        } else {
//            // 一个在左子树一个在右子树 这样的话根就是公共祖先节点 或者一个就是祖先节点
//            return root;
//        }
    // return null;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 节点p的值
        int pVal = p.val;

        // 节点q的值
        int qVal = q.val;

        TreeNode node = root;

        while (node != null) {
            // node 节点的值
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
