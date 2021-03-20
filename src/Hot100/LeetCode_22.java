package Hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22 {

    // 统计开闭括号的情况
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) return res;
        dfs(n, "", res, 0,0);
        return res;
    }
    // 二叉树的前序遍历
    public void dfs_1(int n, String path, List<String> res, int open, int close) {
        if (open > n || close > open) return; // 剪枝
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(n, path + "(", res, open + 1, close); // 左子树
        dfs(n, path + ")", res, open, close + 1); // 右子树
    }

    public void dfs(int n, String path, List<String> res, int open, int close) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        // 剪枝
        if (open < n) {
            dfs(n, path + "(", res, open + 1, close); // 左子树
        }

        if (open > close) {
            dfs(n, path + ")", res, open, close + 1); // 右子树
        }
    }

}
