package Hot100;

import java.util.*;

public class Offer_38 {
    public String[] permutation(String s) {
        char[] strings = s.toCharArray();
        Arrays.sort(strings);
        boolean[] visited = new boolean[s.length()];
        StringBuffer stringBuffer = new StringBuffer();
        List<StringBuffer> ans = new ArrayList<StringBuffer>();
        backtrack(strings, 0, visited, stringBuffer, ans);
        Set<String> ansArray = new HashSet<>();
        for (int i = 0; i < ans.size(); i++) {
            ansArray.add(ans.get(i).toString());
        }
        return ansArray.toArray(new String[ansArray.size()]);
    }

    private void backtrack(char[] string, int startIndex, boolean[] visited, StringBuffer stringBuffer, List<StringBuffer> ans) {
        if (stringBuffer.length() == string.length) {
            ans.add(new StringBuffer(stringBuffer));
            return;
        }
        for (int i = 0; i < string.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            stringBuffer.append(string[i]);
            backtrack(string, i + 1, visited, stringBuffer, ans);
            visited[i] = false;
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
