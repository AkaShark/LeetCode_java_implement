package ACM刷题班;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_547 {

    // DFS
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            // i，j 节点存在边 并且j没有访问过
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum_0(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        // 访问行
        for (int i = 0; i < M.length; i++) {
            // 如果这行没有访问过的话
            if (visited[i] == 0) {
                // 递归调用传入行
                dfs(M, visited, i);
                // 一个新的连通块
                count ++;
            }
        }
        return count;
    }

//    BFS
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 切换行 （节点 开始遍历）
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                // 队列不为空的话 队列存储的是与这个节点连通的节点
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                // 队列为空说明 图连接的中断 要产生新的连通块
                count++;
            }
        }
        return count;
    }


    public int find(int parent[], int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }

    public int findCircleNum_1(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count++;
    }



}
