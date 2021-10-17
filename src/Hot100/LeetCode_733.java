package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_733 {
    // 广度优先实现
    public int[][] floodFill_1(int[][] image, int sr, int sc, int newColor) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int currColor = image[sr][sc];
        if (currColor == newColor) return image;
        int n = image.length, m = image[0].length; // n 行 m 列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >=0 && mx < n && my >=0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }


    // 深度优先实现
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) return image;
        dfs(image, sr, sc, currColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = image.length, m = image[0].length;
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = sr + dx[i];
                int my = sc + dy[i];
                if (mx >= 0 && mx < n && my >=0 && my < m && color == image[sr][sc]) {
                    dfs(image, mx, my, color, newColor);
                }
            }

    }


}
