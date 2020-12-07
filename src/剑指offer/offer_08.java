package 剑指offer;

public class offer_08 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
    /*
    * case1 节点有右子树 则下个节点就是右子树中最左子节点
    * case2 节点没有右子树 且当前节点是左子节点 则下个节点就是当前节点的父节点
    * case3 节点没有右子树 且当前节点是右子节点 则下一个节点需要遍历父节点 找到case2的状态
    * */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // bad case 没有节点的情况
        if (pNode == null) return null;
        // 声明一个最后的结果 并且赋值为null
        TreeLinkNode nextp = null;
        // case1 有右子树，则下个节点是右子树的最左节点
        if (pNode.right != null) {
            // 右子树的根节点
            TreeLinkNode pRight = pNode.right;
            // 寻找右子树的最左子节点
            while (pRight.left != null) pRight = pRight.left;
            // 将最最左子节点赋给结果
            nextp = pRight;
        }
        // case2 cas3
        else if (pNode.next != null) {
            // 当前节点
            TreeLinkNode currentNode = pNode;
            // 当前节点的父节点
            TreeLinkNode parent = pNode.next;
            // case3 如果没有右子树 且当前节点是右子树 则需要遍历父节点 匹配case2
            while (parent != null && currentNode == parent.right) {
                // 遍历父节点
                currentNode = parent;
                parent = parent.next;
            }
            // case2 节点没有右子树 且当前节点是左子树 则下个节点是当前节点的父节点
            nextp = parent;
        }
        // 返回结果
        return nextp;
    }
}
