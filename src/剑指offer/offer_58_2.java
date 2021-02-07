package 剑指offer;

public class offer_58_2 {
    // 时间复杂度也是O(n) 空间复杂度也是O(n) 但是没有下面的方法表现好
    public String reverseLeftWords_1(String s, int n) {
        if (s == null || s.length() == 0 || n == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length()));
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // 和我的一样LeetCode解法
    public String reverseLeftWords_2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
    // 利用取余操作简化
    public String reverseLeftWords_3(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    public String reverseLeftWords_4(String s, int n) {
        if (s == null || s.length() == 0 || n == 0) return "";
        return s.substring(n, s.length()) + s.substring(0 , n);
    }

    public String reverseLeftWords_5(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }

    public String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length() ; i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }




}
