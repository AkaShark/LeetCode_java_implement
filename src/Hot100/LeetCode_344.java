package Hot100;

public class LeetCode_344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (right >= left) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        return;
    }
}
