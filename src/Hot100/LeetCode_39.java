package Hot100;

import java.util.ArrayList;
import java.util.List;
/*
* 对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决。
* 和剑指offer上的机器人找路径的很相似 总结下
*/
public class LeetCode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        // 递归出口
        if (index == candidates.length) return;
        if (target == 0) {
            // 添加结果
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, index + 1);
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            // 重复使用
            dfs(candidates, target - candidates[index], ans, combine, index);
            combine.remove(combine.size() - 1);
        }

    }
}
