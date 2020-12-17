package 剑指offer;

public class offer_17 {
    // 大数问题
    /*
    * 用字符串或者数组模拟大数
    * */

    // 时间复杂度极高并且没有考虑大数的情况
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    // 大数解法 使用字符串处理大数问题 全排列处理
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6' ,'7', '8', '9'};
    public String printNumbers_1(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为n的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最优多余的逗号
        return res.toString(); // 转化为字符串返回
    }

    public void dfs(int x) {
        // 终止条件 已经固定完所有的位
        if (x == n) {
            // 拼接num 并添加到res 尾端
            res.append(String.valueOf(num) + ",");
            return;
        }
        // 遍历 0 - 9
        for (char i: loop) {
            // 固定第x位为i
            num[x] = i;
            dfs(x + 1);
        }

    }

}
