package Hot100;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_542 {
    // 这个题不太会 广度优先去做的

    // 这个方法不对 边界case出错了
//    public int[][] updateMatrix(int[][] mat) {
//        int[][] ans = new int[mat.length][mat[0].length];
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if (mat[i][j] == 0) { // 不用寻找 本身就是0
//                    ans[i][j] = 0;
//                } else {
//                    ans[i][j] = dfs(mat, i, j);
//                }
//            }
//        }
//        return ans;
//    }
//
//    private int dfs(int[][] mat, int sr, int sc) {
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//        int count = 1;
//        int flag = 0;
//        for (int i = 0; i < 4; i++) {
//            int mx = sr + dx[i], my = sc + dy[i];
//            if (mx == mat.length -1 && my == mat[0].length -1) flag ++; // 边界条件
//            if (mx >= 0 && mx < mat.length && my >= 0 && my < mat[0].length && mat[mx][my] != 0) {
//                flag ++;
//                mat[mx][my] = 0;
//                dfs(mat, mx, my);
//                mat[mx][my] = 1;
//            }
//        }
//        if (flag == 4) {
//            count ++;
//        }
//        return count;
//
//    }

    // 广度优先使用 不会
//    public int[][] updateMatrix(int[][] mat) {
//        int[][] ans = new int[mat.length][mat[0].length];
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                if (mat[i][j] ==  0) {
//                    ans[i][j] = 0;
//                }  else {
//                    Queue<int[]> queue = new LinkedList<>();
//                    queue.offer(new int[]{i, j});
//                    while (!queue.isEmpty()) {
//                        int size = queue.size();
//                        for (int z = 0; z < size; z++) { //
//                            for (int k = 0; k < 4; k++) { // BFS
//                                int mx = dx[k] + queue.poll()[0], my = dy[k] + queue.poll()[1];
//                                if (mx >= 0 && mx < mat.length && my >= 0 && my < mat[0].length && mat[mx][my] != 0) {
//                                    mat[queue.poll()[0]][queue.poll()[1]] = 0;
//                                    queue.offer(new int[]{mx, my});
//                                } else {
//                                    mat[queue.poll()[0]][queue.poll()[1]] = 1;
//                                    ans[queue.poll()[0]][queue.poll()[1]] ++;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ans;
//    }

    // 多起点的广度优先搜素
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        int row = mat.length, col = mat[0].length;
        int[][] visited = new int[row][col];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] ++;
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                if (mat[x][y] == 1) {
                    ans[x][y] = step;
                }
                for (int i = 0; i < 4; i++) {
                    int mx = dx[i] + x, my = dy[i] +y;
                    if (mx >= 0 && mx < row && my >= 0 && my < col && visited[mx][my] != 1) {
                        visited[mx][my] = 1;
                        queue.offer(new int[]{mx, my});
                    }
                }
                size --;
            }
            step ++;
        }
        return ans;
    }

}

