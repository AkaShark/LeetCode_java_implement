package ACM刷题班;

public class LeetCode_374 {

    // 二分法
    public int guessNumber(int n) {
        int start = 1, end = n;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int res = guess(middle);

            if (end == start) return middle;

            if (res == -1) {
                end = middle;
            } else if (res == 1) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return 0;
    }

    // 三分查找
    public int guessNumber_1(int n) {
        int low = 1;
        int hight = n;
        while (hight >= low) {
            int mid1 = low + (hight - low) / 3;
            int mid2 = hight - (hight - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0) return mid1;
            if (res2 == 0) return mid2;
            else if (res1 < 0) hight = mid1 - 1;
            else if (res2 > 0) low = mid2 + 1;
            else {
                low = mid1 + 1;
                hight = mid2 - 1;
            }
        }
        return -1;
    }

    int guess(int num) {
        return 0;
    }
}
