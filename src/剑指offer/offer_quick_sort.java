package 剑指offer;

import java.util.Arrays;

public class offer_quick_sort {
    /*
    * 快速排序的思想是：
    * 通过一趟排序将要排序的数据分割成独立的两部分，
    * 其中一部分的所有数据都比另外一部分的所有数据都要小，
    * 然后再按此方法对这两部分数据 分别 进行快速排序，
    * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
    * */

    /*
    * 1. 选择基准值：在待排序序列中，按照某种方式挑选出一个元素，作为基准值
    * 2. 分割操作： 以该基准值在序列中的实际位置，把序列分割成两个部分，一部分是基准值小的部分，另一部分是比基准值大的部分，
    * （这轮排序结束后，基准值位于排序最终的位置）
    * 3. 递归 对两个子序列进行快速排序，知道序列为空或者只有一个元素
    * */

    public static void main(String[] args) {
        int[] array = new int[] {9,4,6,8,3,10,4,6};
        quickSork(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSork(int[] arr, int low, int high) {
        int p, i, j, temp;
        // 没有元素需要遍历了
        if (low >= high) {
            return;
        }

        // p就是基准值， 这里就是每个数组的第一个元素
        p = arr[low];
        i = low;
        j = high;

        // 准备遍历
        while (i < j) {
            // 右边的指针先动起来
            // 右边当发现小于p的值时候停止循环
            while (arr[j] >= p && i < j) j--;

            // ps: 这里 一定是右边开始， 上下这两个循环不能调换

            // 左边当发现大于p的值时候停止循环
            while (arr[i] <= p && i < j) i++;


            // Swap
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

        }
        // swap  i和low位置元素互换 最后的时候low和iswap下
        arr[low] = arr[i];
        arr[i] = p;

        // 对左边快排
        quickSork(arr, low, j-1);
        // 对右边快排
        quickSork(arr, j + 1, high);

    }
}
