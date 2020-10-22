package 杂项;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> res = new LinkedList<>();

        if (coins[0] > amount) {
            return -1;
        }
        int len = coins.length;
        while (amount != 0 && len > 0) {
            if (coins[len-1] < amount) {
                amount -= coins[len-1];
                res.add(coins[len-1]);
            } else {
                len--;
            }

        }
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i);
        }

        if (sum != amount) {
            return -1;
        }
        return res.size();
    }
}
