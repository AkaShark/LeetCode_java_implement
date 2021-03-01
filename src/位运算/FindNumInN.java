package 位运算;

public class FindNumInN {
    /*
    * 输入1~n共n个数，打乱后随机删除一个，找出删除的那个数，
    * 不许排序 && 不使用其它变量，
    * 实现两个数字的交换*/
    static int FindNumInN(int[] origin_nums, int[] current_nums) {
        int res = 0;
        for (int num: origin_nums) {
            res = res ^ num;
        }
        for (int num: current_nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = FindNumInN(new int[]{1,2,3,4,}, new int[]{4,2,1});
        System.out.println(res);
    }
}
