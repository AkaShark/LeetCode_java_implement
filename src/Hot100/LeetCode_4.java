package Hot100;

import java.util.Arrays;

public class LeetCode_4 {
    // 暴力法
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            array[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            array[i + nums1.length] = nums2[i];
        }
        Arrays.sort(array); // nlogn
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            return (array[length / 2] + array[length / 2 - 1]) / 2;
        } else {
            return array[length / 2];
        }
    }

    // 半暴力法
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0; // 标记当前访问的num1 和 num2 的位置
        for (int i = 0; i <= len / 2; i++) {
            left = right; // left 记录上次的值 right保留最新的值
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        // 这个方法只需要最后或得到 最后的left和right
        if ((len & 1) == 0) { // 偶数
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    //
    public double findMedianSortedArrays_3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // 选K的过程不不太理解
        int left = (n + m + 1) / 2; // 奇数
        int right = (n + m + 2) / 2; // 偶数
        // 将偶数和奇数的情况合并 如果是奇数 会求两次同样的k
        return (getKth(nums1, 0, n-1, nums2, 0, m-1, left) + getKth(nums1, 0, n-1, nums2, 0,m-1, right)) / 2;

    }

    private  int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 交换
        // 保证len1的长度小于len2 这样如果一个数组为空的话一定是len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1,k);
        if (len1 == 0) return nums2[start2 + k -1]; // 直接返回

        // 递归出口
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        // 舍弃j前面的元素
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    // 同上方法将奇数偶数拆开 分别处理
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (((len1 + len2) & 1) == 0) { // 偶数
            return (findKElement(nums1, 0, len1, nums2, 0, len2, (len1+len2) / 2) + findKElement(nums1, 0, len1, nums2, 0, len2, (len1+len2) / 2 + 1)) * 0.5;
        } else {
            return findKElement(nums1, 0, len1, nums2, 0, len2, (len1+len2 + 1) / 2);
        }
    }

    private int findKElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k ) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return findKElement(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(k / 2, len1) - 1;
        int j = start2 + Math.min(k / 2, len2) - 1;

        if (nums1[i] > nums2[j]) { // 移除nums2前面的元素
            return findKElement(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return findKElement(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
