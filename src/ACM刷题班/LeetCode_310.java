package ACM刷题班;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // bad case
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        // 成图
        // 出度表
        int[] degree = new int[n];
        // 建立图关系 在每个节点上的list中存储相连节点 邻接表链表
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++; // 出度
            // 邻接表 添加临接节点
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }


        // 建立队列
        Queue<Integer> queue = new LinkedList<>();
        // 把所有出度为1的节点，也就是叶子节点入队
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            // 没吃呢个循环都要new一个新的结果集 这样最后保存的就是最终的最小高度树
            res = new ArrayList<>();
            // 每一层节点的数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 把当前节点加入结果集
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }

            }
        }
        return res;
    }
}
