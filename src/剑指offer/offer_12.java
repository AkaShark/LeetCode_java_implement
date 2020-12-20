package 剑指offer;

public class    offer_12 {

    // 牛客上的题目解答
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] viested = new boolean[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(matrix, row, rows, col, cols, str, 0, viested)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[] matrix, int row, int rows, int col, int cols, char[] str, int len, boolean[] viested) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || str[len] != matrix[row * cols + col] || viested[row * cols + col])
            return false;
        // 及时返回 到最后了就证明OK了 返回
        if (len == str.length - 1) return true;
        viested[row * cols + col] = true;
        boolean isExit = dfs(matrix, row + 1, rows, col, cols, str, len + 1, viested) ||
                dfs(matrix, row - 1, rows, col, cols, str, len + 1, viested) ||
                dfs(matrix, row, rows, col + 1, cols, str, len + 1, viested) ||
                dfs(matrix, row, rows, col - 1, cols, str, len + 1, viested);

        viested[row * cols + col] = false;
        return isExit;
    }
}




    // 思路就是利用回溯法遍历每个节点找到对应的路径 如果走错一步的话
    // 利用回溯去上一个节点继续找 除了在边界的节点其他节点都是有四个选项
    // 回溯法的实现使用递归来实现
//
//    static public boolean exist(char[][] board, String words) {
//        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || words == null || words.equals("")) return false;
//        char[] word = words.toCharArray();
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        int pathLocal = 0;
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                if (dfs(row, col, board.length, board[0].length, pathLocal, word, board, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    static public boolean dfs(int row, int col, int rows, int cols, int pathLocal, char[] words, char[][] board, boolean[][] visited) {
//        if (pathLocal == words.length) return true;
//        if (row < 0 || row >= rows || col < 0 || col >= cols || words[pathLocal] != board[row][col] || visited[row][col]) return false;
//
//        visited[row][col] = true;
//        boolean isExit =  dfs(row + 1, col, rows, cols, pathLocal + 1, words, board, visited) ||
//                dfs(row - 1, col, rows, cols, pathLocal + 1, words, board, visited) ||
//                dfs(row, col - 1 , rows, cols, pathLocal + 1, words, board, visited) ||
//                dfs(row, col + 1, rows, cols, pathLocal + 1, words, board, visited);
//
//        visited[row][col] = false;
//        return isExit;
//    }
//
//    public static void main(String[] args) {
//        String example = "ab";
//        char[][] board = {{'a'}};
//        System.out.println(exist(board, example));
//
//        };
//
//    }
//
//
//







//    public boolean exist(char[][] board, String word) {
//        if (board == null || board[0].length == 0 || board.length == 0) return false;
//        boolean[][] visited = new boolean[][]{{false}};
//
//        int pathLength = 0;
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                if (hasPathCore(board, board.length, board[0].length, row, col, word, pathLength, visited)) {
//                    return true;
//                }
//
//            }
//        }
//        return false;
//    }
//
//    public boolean hasPathCore(char[][] board, int rows,
//                               int cols, int row, int col,
//                               String str, int pathLength, boolean[][] visit) {
//        if (pathLength == str.length()) return true;
//
//        boolean hasPath = false;
//        if (row >= 0 && row < rows && col >=0 && col < cols && board[row*cols][col] == str.charAt(pathLength) && !visit[row*cols][col]) {
//            ++pathLength;
//            visit[row * cols][col] = true;
//            hasPath = hasPathCore(board, rows, cols, row, col - 1, str, pathLength, visit) ||
//                      hasPathCore(board, rows, cols, row, col + 1, str, pathLength, visit) ||
//                      hasPathCore(board, rows, cols, row + 1, col, str, pathLength, visit) ||
//                      hasPathCore(board, rows, cols, row - 1, col, str, pathLength, visit);
//            if (!hasPath) {
//                --pathLength;
//                visit[cols * row][col] = false;
//            }
//        }
//        return hasPath;
//
//    }

    // LeetCode解法 DFS + 剪枝
    /*
    * 深度优先搜索：可以理解为暴力法遍历矩阵中所有字符串可能性，DFS通过递归
    * 先朝着一个方向搜素到底，再回溯到上个节点，沿另一个方向搜索，一次类推知道找到匹配的路径
    * 剪枝：在搜索中，遇到这条路不可能和目标字符串匹配成功的情况，则立即返回，成为可行性剪枝*/

    /* DFS解析
    * 递归参数: 当前元素在矩阵board中行列索引 i 和 j ， 当前目标字符在word中的索引k
    * 终止条件:
    *   1. 返回false 行列越界 当前矩阵元素和目标字符不同 当前矩阵元素已经访问过了
    *   2. 返回true k = len(word) - 1 , 及字符串word已经全部遍历完*/

//    public boolean exist(char[][] board, String word) {
//        // 将word转成array
//        char[] words = word.toCharArray();
//        // 遍历矩阵的每个元素
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                if (dfs(board, words, row, col, 0)) return true;
//            }
//        }
//        return false;
//    }
//
//    boolean dfs(char[][] board, char[] word, int row, int col, int k) {
//        // bad case
//        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word[k]) return false;
//        // 遍历完了整字符串
//        if (k == word.length - 1) return true;
//        // 将遍历到的字符变成\0 防止重复访问 同时这样做不用设置visited数组节约内存空间 和创建visited[] 原理是一样的但是这样的话减少了空间复杂度
//        board[row][col] = '\0';
//        boolean res = dfs(board, word, row + 1, col, k + 1) ||
//                      dfs(board, word, row - 1, col, k + 1) ||
//                      dfs(board, word, row, col + 1, k + 1)  ||
//                      dfs(board, word, row, col - 1, k + 1);
//        // 将遍历到的字符变回去
//        board[row][col] = word[k];
//        return res;
//
//    }

//}
