package Hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, 0, list, res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] visited, int startIndex, List<Integer> list, List<List<Integer>> ans) {
        if (nums.length == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= nums.length ; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(nums, visited, i + 1, list, ans);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
