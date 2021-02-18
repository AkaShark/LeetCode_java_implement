package 剑指offer;

public class offer_65 {
    // s = a + b => n + c c为0
    public int add_1(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // c 为进位
            a ^= b; // a 为 非进位和
            b = c; // b 为进位
        }
        return a;
    }

    // 递归实现
    public int add(int a, int b) {
        if (b == 0) return a;
        return add(a^b, (a & b) << 1);
    }

}
