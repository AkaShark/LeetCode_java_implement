package 剑指offer;

public class offer_15 {
    static public int hammingWeight(int n) {
        int count_1 = 0;
        int flag = 1;
        int count = 0;
        // flag一直向左移 这个方法循环次数等于整数的最大二进制位数为32
        while (flag != 0) {
            int is_1 = n & flag;
            // 只要不是0的话就 说明包含一位二进制位1的数字
            if (is_1 != 0) count_1++;
            flag = flag << 1;
        }
        return count_1;
    }

    // 第二种方法 循环输入整数的二进制的1的个数次
    /*
    * 把一个整数减去1，在和原整数左按位与运算，会把该整数最右边的1变成0
    * 那么一个整数的二进制表示中有多少个1就进行多少次这样的操作*/
    static public int Number0f_1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            // 减去1 与 原数做按位与运算
            n = (n - 1) & n;
        }
        return count;
    }


    /*
    * 把一个整数减去1之后再和原来的整数做按位与运算，得到的结果相当于
    * 把整数的二进制表示中最右边的1变成0，很多二进制问题都可以用这个思路解决
    * */

    public static void main(String[] args) {
        hammingWeight(1111);
    }
}
