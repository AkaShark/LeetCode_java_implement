package ACM刷题班;

public class LeetCode_275 {
    /*h 指数的定义: “h 代表“高引用次数”（
    high citations），一名科研人员的 h 指数是指他（她）的
    （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（
    其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"*/
    // 找中间值吧。。。
//    public int hIndex(int[] citations) {
//        int idx = 0, n = citations.length;
//        for(int c : citations) {
//            if (c >= n - idx) return n - idx;
//            else  idx++;
//        }
//        return 0;
//    }

    public int hIndex(int[] citations) {
        int idx = 0, n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
            pivot = (left + right) >>> 1;
            if (citations[pivot] == n - pivot) return n - pivot;
            else if (citations[pivot] < n - pivot) left = pivot + 1;
            else right = pivot - 1;
        }
//        return n - right -1;
        return n-left;
    }


}
