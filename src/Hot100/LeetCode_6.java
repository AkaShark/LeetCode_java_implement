package Hot100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_6 {
    public String convert(String s, int numRows) {
        List<StringBuilder> sbs = new ArrayList<>(); // 记录每行的数组
        int rows = Math.min(s.length(), numRows); // 标记总共有多少非空行
        for (int i = 0; i < rows; i++) {
            sbs.add(new StringBuilder());
        }

        if (rows == 1) return s; // case

        int curRow = 0; // 标识当前行数
        boolean director = false; // 标识向上向下 +1 -1

        for (int i = 0; i < s.length(); i++) { // 遍历每个字符 将每个字符放到合适的位置上
            char item = s.charAt(i);
            sbs.get(curRow).append(item);
            if (curRow == 0 || curRow == rows - 1) // 第一行 最后一行 需要转向
                director = !director; // 垂直方向上的改变
            curRow = curRow + (director? 1: -1); // 是否是向下的 向下的 + 1
        }

        // 将每一行整合到一个stringbuidler中
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbs.size(); i++) {
            res.append(sbs.get(i));
        }
        return res.toString();
    }
}
