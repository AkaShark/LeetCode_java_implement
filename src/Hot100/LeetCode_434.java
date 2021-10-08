package Hot100;

public class LeetCode_434 {
    public int countSegments_1(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int left = 0, right = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char string = s.charAt(i);
            if (string != ' ') {
                right ++;
            } else {
                if (right > left) {
                    res ++;
                }
                left = right;
                left ++;
                right ++;
            }
        }
        return res;
    }

    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                res ++;
            }
        }
        return res;
    }
}
