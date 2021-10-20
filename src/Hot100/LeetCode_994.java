package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_994 {
    // 广度优先
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int row = grid.length, col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int zero = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 0) {
                    zero ++;
                }
            }
        }
        int mins = 0, total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            total += size;
            while (size > 0) {
                int[] cell = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = cell[0] + dx[i], my = cell[1] + dy[i];
                    if (mx >= 0 && mx < row && my >= 0 && my < col && grid[mx][my] == 1) {
                        grid[mx][my] = 2;
                        queue.offer(new int[]{mx, my});
                    }
                }
                size --;
            }
            if (!queue.isEmpty()) mins ++;
        }
        if (total == row * col - zero) return mins;

        return -1;
    }
}
