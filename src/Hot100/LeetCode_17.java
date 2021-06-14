package Hot100;

import java.util.*;

public class LeetCode_17 {
    // 对照的映射
    Map<Character, String> phone = new HashMap<>();
    phone.put('2',"abc");
    phone.put('3',"def");
    phone.put('4',"ghi");
    phone.put('5',"jkl");
    phone.put('6',"mno");
    phone.put('7',"pqrs");
    phone.put('8',"tuv");
    phone.put('9',"wxzy");

    public List<String> letterCombinations_1(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();

        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            temp.add(phone.get(digits.charAt(i)));
        }

        // 全排列 ["abc", "def"]
        List<String> ans = combination(temp);

        return ans;
    }

    // 关键代码 回溯法  组合求全排列
    public List<String> combination(List<String> inputList) {
        List<String> resList = new ArrayList<>();
        combinationInt(inputList, resList, 0,
                new char[inputList.size()]);
        return resList;
    }

    private void combinationInt(List<String> inputList, List<String> resList,
                                int ind, char[] arr) {
        if (ind == inputList.size()) {
            resList.add(new String(arr));
            return;
        }
        // 将String转成CharArray ["abc", "def"] => [a, b, c]
        for (char c : inputList.get(ind).toCharArray()) {
            arr[ind] = c;
            // 递归的整合
            combinationInt(inputList, resList, ind + 1, arr);
        }
    }



    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations;
        backtrack(combinations, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phone.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                // 回溯 与上一个方法的不同的地方在于上一个使用char[] 来放对应的生成好的子字符串 但是这个方法使用StringBuffer来装 上一个依托于index 这个直接使用相对灵活的StringBuffer
                backtrack(combinations, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    // 队列实现 最终的queue就是结果
    public List<String> letterCombinations_2(String digits) {
        Queue<String> queue = new LinkedList<String>();
        List<String> phone = new ArrayList<>();
        if(digits.length()==0) return new ArrayList<String>();
        phone.add("abc");
        phone.add("def");
        phone.add("ghi");
        phone.add("jkl");
        phone.add("mno");
        phone.add("pqrs");
        phone.add("tuv");
        phone.add("wxyz");

        // 第一个
        int index0 = digits.charAt(0) - '0';
        String abc0 = phone.get(index0 - 2);
        for (int k = 0; k < abc0.length(); k++) {
            String ll = abc0.substring(k, k + 1);
            queue.add(ll); // 第一个添加到队列中
        }

        // 后序的拼接 添加了一个
        for (int i = 1; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0';
            // 下一个String
            String abc = phone.get(index - 2);
            // 队列中有几个元素
            int current = queue.size();
            for (int l = 0; l < current; l++) {
                for (int k = 0; k < abc.length(); k++) {
                    String ll = queue.peek() + abc.substring(k, k + 1);
                    queue.add(ll); // 添加到队列中
                }
                queue.poll();
            }
        }

        return (List<String>) queue;
    }

}
