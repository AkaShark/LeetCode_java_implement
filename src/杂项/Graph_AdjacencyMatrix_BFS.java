package 杂项;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_AdjacencyMatrix_BFS {

    // 邻接矩阵的广度遍历 假设传过来的二阶矩阵

    public void Graph_AdjacencyMatrix_DFS(int[][] M) {
        int[] visited = new int[M.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < M.length ; i++) {
            if (visited[i] == 0) {
                queue.offer(i);

                // 一个连通区域
                while (!queue.isEmpty()) {
                    int t = queue.poll();
                    visited[i] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[t][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        
    }
}
