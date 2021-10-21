package Hot100;


import java.util.ArrayList;
import java.util.List;

public class LeetCode_784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        backtrack(chs, n, 0);
        return res;
    }

    private void backtrack(char[] chs, int n, int begin) {
        res.add(new String(chs));
        for(int i = begin; i < n; i++){
            if(!Character.isDigit(chs[i])){
                char tmp = chs[i];
                chs[i] = (char)(chs[i] - 'a' >= 0 ? chs[i] - 32 : chs[i] + 32);
                backtrack(chs, n, i + 1);
                chs[i] = tmp;
            }
        }
    }
}
