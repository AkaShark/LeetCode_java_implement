package Hot100;

import java.util.Scanner;

public class tanqiu {
    public static void main(String[] args) {

    }
    public static int mus(int[] array) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (check(array[i], array[j], L, R)) {
                    num ++;
                }
            }
        }
        return num;
    }
    public static boolean check(int i , int j, int L , int R) {
        int num = i + j;
        if (num > L && num < R) return true;
        return false;
    }
}
