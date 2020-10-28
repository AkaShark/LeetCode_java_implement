package 杂项;

public class Graph_AdjacencyMatrix_DFS {
    // 邻接矩阵的深度遍历 假设传过来的二阶矩阵

    public void Graph_AdjacencyMatrix_DFS(int[][] M) {
        int visited[] = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                DFS(M,visited,i);
            }
        }
    }

    public void DFS(int[][] M, int[] visited,int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                DFS(M, visited, j);
            }
        }
    }

}
