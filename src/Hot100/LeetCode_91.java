package Hot100;

public class LeetCode_91 {
    public int numDecodings_1(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i - 2) - '0') < 26)) {
                f[i] += f[i-2];
            }
        }
        return f[n];
    }

    // 简化 使用三个变量代替动态方程数组
//    f[i] f[i - 1] f[i - 2]
//    f[i] += f[i - 1]
//    f[i] += f[i - 2]
//    f[i - 2] = a, f[i - 1] = b; f[i] = c;
    public int numDecodings(String s) {
        int n = s.length();
        int a = 0,b = 1,c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i - 2) - '0') < 26) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
