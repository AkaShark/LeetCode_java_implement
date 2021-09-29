package Hot100;

public class LeetCode_58 {
    // 创建String
    public String reverseLeftWords_1(String s, int n) {
        if (s == null || s.length() < n) return new String();
        StringBuilder ans = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            ans.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public String reverseLeftWords_2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public String reverseLeftWords_3(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();

    }

    public String reverseLeftWords(String s, int n) {
        String ans = new String();
        for (int i = n; i < s.length() + n; i++) {
            ans += s.charAt(i % s.length());
        }
        return ans;
    }

}
