package 杂项;

public class leetcode_7 {
    // 除以10循环解决  这样的话解决不了整数移除的情况
   static public int reverse_1(int x) {
        if (x == 0) return 0;
        int sum = 0;
        while (x != 0) {
            sum +=  x % 10;
            sum *=10;
            x /= 10;
        }

        return sum / 10;
    }

    // leetcode 版本
    static public int reverse_2(int x) {
       int res = 0;
       while (x != 0) {
           int pop = x % 10;
           x /= 10;
           if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
           if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
           res = res * 10 + pop;
       }
       return res;
    }

    // 解释 -7 8 的版本
    static public int reverse_3(int x) {
       int res = 0;
       while (x != 0) {
           int pop = x % 10;
           x /= 10;
           if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
           if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;
           res = res * 10 + pop;
       }
       return res;
    }

    static public int reverse(int x) {
       int ans = 0;
       while (x != 0) {
           // 存在整数溢出
           if ((ans * 10) / 10 != ans) {
               return 0;
           }
           ans = ans * 10 + x % 10;
           x /= 10;
       }
       return ans;
    }


    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
    }
}
