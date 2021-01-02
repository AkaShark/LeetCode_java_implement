package 剑指offer;

public class offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        // 找左子树
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        // 找右子树
        while (postorder[p] > postorder[j]) p++;
        // 是否符合 p == j 符合二叉搜索树的定义 然后递归的去找左右子树是否符合
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
