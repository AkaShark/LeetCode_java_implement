package 剑指offer;

public class offer_19 {
    // 原答案 但是好像不可以 这个题看不懂群魔乱舞啊 hard 过了
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return matchCore(s, p, 0, 0);
    }

    public boolean matchCore(String s, String p, int sindex, int pindex) {
        if (sindex >= s.length() || pindex >= p.length()) return false;
        if (s.charAt(sindex) == '\0' && p.charAt(pindex) == '\0') return true;
        if (s.charAt(sindex) != '\0' && p.charAt(pindex) == '\0') return false;
        if (s.charAt(sindex + 1) == '*') {
            if (p.charAt(pindex) == s.charAt(sindex) || p.charAt(pindex) == '.' && s.charAt(sindex) == '\0')
                return matchCore(s, p, sindex + 1, pindex + 2) ||
                        matchCore(s, p, sindex + 1, pindex) ||
                        matchCore(s, p, sindex, pindex + 2);
            else
                // 第一个字符不相等 忽略过去
                return matchCore(s, p, sindex, pindex);
        }


        if (s.charAt(sindex) == p.charAt(pindex) || (p.charAt(pindex) == '.' && s.charAt(sindex) != '\0'))
            return matchCore(s, p, sindex + 1, pindex + 1);

        return false;
    }

}
