package Hot100;

public class LeetCode_11 {
    // 遍历法 时间复杂度过高
    public int maxArea_1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = max <= area ? area : max;
            }
        }
        return max;
    }

    // 双指针法
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int max = 0;
        while (right >= left) {
            int h = Math.min(height[left], height[right]);
            int area = (h * right - left);
            max = area > max ? area : max;
            if (height[right] > height[left]) left ++;
            else right --;
        }
        return max;
    }

}
