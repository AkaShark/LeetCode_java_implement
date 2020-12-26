package 杂项;

import java.util.ArrayList;
import java.util.List;

public class mima {
    public static void main(String[] args) {
        char[] array = new char[]{'a', 'b', 'c', 'd'};
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            System.out.println((char) (((int) (array[i]) + 4) % 26));
            list.add((char)((array[i] + 4) % 26));
        }
    }
}
