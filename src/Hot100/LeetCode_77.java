package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backtrack(n, k, 1,path, ans);
        return ans;
    }

    private void backtrack(int n, int k, int startIndex, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            list.add(i);
            backtrack(n,k,i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
