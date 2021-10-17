package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_695 {
    // 广度优先搜索
    public int maxAreaOfIsland_1(int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { // 启点
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    int tem = 1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        for (int k = 0; k < 4; k++) {
                            int mx = x + dx[k], my = y + dy[k];
                            if (mx >= 0 && mx < row && my >= 0 && my < col && grid[mx][my] == 1) {
                                tem ++;
                                queue.offer(new int[]{mx, my});
                                grid[mx][my] = 0;
                            }
                        }
                    }
                    ans = tem > ans? tem: ans;
                }
            }
        }
        return ans;
    }


    // 深度优先
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { // 启点
                   int temp = dfs(grid, i, j);
                   ans = temp > ans? temp: ans;
                }
            }
        }
        return ans;
    }

    private int dfs(int[][]grid, int sr, int sc) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int temp = 1;
        for (int i = 0; i < 4; i++) {
            int mx = sr + dx[i], my = sc + dy[i];
            if (mx >= 0 && mx < grid.length && my >= 0 && my < grid[0].length && grid[sr][sc] == 1) {
                dfs(grid, mx, my);
                temp ++;
            }

        }
        return temp;

    }


}
