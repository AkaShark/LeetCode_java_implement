package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;

public class offer_45 {
    // 找规律问题
    // 让最高位的数 最小其中一步比较就是遍历数确定第二位也是小的
    public String minNumber(int[] nums) {
        // 将int[] 转为 String 类型数组
        String[] strs = new String[nums.length];
        // 对于String类型数组 进行按规则排序
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        quickSort(strs, 0, strs.length - 1);

        // 拼接排序完的数组
        StringBuilder res = new StringBuilder();
        for (String s: strs)
            res.append(s);
        // 转字符串
        return res.toString();
    }

    // 快排
    void quickSort(String[] strs, int l, int r) {
        if (l > r) return;
        int i = l, j = r;
        // 取第一个作为标准值
        String tmp = strs[l];
        while (i < j) {
            // 快排的比较规则 针对题目进行修改
            /*
            *  x + y > y + x 则 x 大于 y
            *  x + y < y + x 则 x 小于 y*/
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i< j) i++;
            // swap
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }

        strs[i] = strs[l];
        strs[l] = tmp;

        // i 就是中间的值了 index i移动了i变成了index 与 前两天做的快排不动 比较学习
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    public String minNumber_1(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s: strs)
            res.append(s);
        return res.toString();
    }

}
