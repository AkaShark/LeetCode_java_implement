package Hot100;

import java.util.*;

public class LeetCode_17 {
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

    // 关键代码 回溯法
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
        // 将String转成CharArray
        for (char c : inputList.get(ind).toCharArray()) {
            arr[ind] = c;
            combinationInt(inputList, resList, ind + 1, arr);
        }
    }

    // 队列实现
    public List<String> letterCombinations(String digits) {

    }


}
