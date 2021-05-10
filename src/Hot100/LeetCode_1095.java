package Hot100;

public class LeetCode_1095 {
    interface MountainArray {
        // 获取值
        public default int get(int index) {
            return 0;
        }

        // 获取长度
        public default int length() {
            return 1;
        }
    }

    // 使用二分法 不断的缩小问题的规模
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr == null || mountainArr.length() == 0) return -1;
        int l_res, r_res;
        // 山顶
        int mountainTop = peakIndexInMountainArray(mountainArr);
        if (target == mountainArr.get(mountainTop)) {
            return mountainTop;
        } else {
            // 左边 正序
            int l_left = 0, l_right = mountainTop;
            while (l_left < l_right) {
                int l_mid = l_left + (l_right - l_left) / 2;
                if (target < mountainArr.get(l_mid)) {
                    l_right = l_mid - 1;
                } else {
                    l_left = l_mid;
                }
            }

            l_res = l_left;

            // 右边
            int r_left = mountainTop + 1, r_right = mountainArr.length() - 1;
            while (r_left < r_right) {
                int r_mid = r_left + (r_right - r_left) / 2;
                if (target < mountainArr.get(r_mid)) {
                    r_left = r_mid + 1;
                } else {
                    r_right = r_mid;
                }
            }

            r_res = r_left;
        }

        if (mountainArr.get(l_res) == target) return l_res;
        else if (mountainArr.get(r_res) == target) return r_res;
        else return -1;

    }

    // 找到山顶
    public int peakIndexInMountainArray(MountainArray arr) {
        int left = 0, right = arr.length() - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) { // left左边都不要了
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
