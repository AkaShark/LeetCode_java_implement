package 剑指offer;

public class offer_58_1 {

    // 我的实现双指针 标记单词的始末点
    //    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) return "";
//        s = s.trim();
//        int index = s.length();
//        StringBuilder res = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0 ; i--) {
//            if (s.charAt(index) == ' ') {
//                System.out.println("1");
//                index = i - 1;
//                continue;
//
//            }
//            if (s.charAt(i) == ' ') {
//                res.append(s.substring(i + 1, index)).append(' ');
//                index = i - 1;
//            }
//            if (i == 0) {
//                res.append(s.substring(i, index));
//            }
//        }
//        return res.toString().trim();
//    }

    // LeetCode 实现 思路和我一样但是实现比我好
    public String reverseWords_1(String s) {
        s = s.trim(); // 删除收尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + ' '); // 不包括j
            while (i >=0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim();
    }


    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除尾部空格 利用空格分隔
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历
            if (strs[i].equals("")) continue; // 遇到空格直接跳过
            res.append(strs[i] + " "); // 将单词凭借到stringBuilder
        }
        return res.toString().trim(); // 转化为字符串 删除尾部空格 并返回
    }

}
