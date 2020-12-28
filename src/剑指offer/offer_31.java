package 剑指offer;

import java.util.Stack;

public class offer_31 {
    /*
     * 出栈序列不可能正确的条件：
     * 1. 已经在栈中的元素不能早于前面的元素
     * 借助辅助栈实现 通过辅助栈找到符合条件的出栈元素并且出栈 看最后是否满足条件
     * */

    public boolean validateStackSequences_1(int[] pushed, int[] popped) {
        // 主要考虑栈违规操作
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed.length == 0 || popped.length == 0) return false;

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;

        while (pushed.length > pushIndex) {
            stack.push(pushed[pushIndex++]);
            // 可以连续的pop
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        // 最后返回stack是否为空就可以了
        return stack.isEmpty();

    }


    //   LeetCode 比较复杂 看懂思路就可以了不太推荐
    public boolean validateStackSequences_2(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        if (pushed.length == 1 && popped.length == pushed.length) return true;
        Stack<Integer> help = new Stack<>();
        // pos标记着pushed元素的位置 i表示这popped元素的位置下标
        int pos = 0, pushSize = pushed.length, popSize = popped.length;

        for (int i = 0; i < popSize; i++) {
            if (pos >= pushSize) {
                // case3
                while (i != popSize) {
                    if (help.peek() != popped[i]) return false;
                    help.pop();
                    i++;
                }
                break;
            }
            if (popped[i] == pushed[pos]) {
                // case1
                pos++;
                continue; // 让i++ 元素进栈后又出栈
            } else {
                // case2
                if (!help.empty()) {
                    // 假如pos在pushed的最后一位且栈顶元素不匹配， false
                    if (pos == pushSize - 1 && help.peek() != popped[i]) return false;
                    else if (pos < pushSize && help.peek() == popped[i]) {
                        help.pop();
                        continue;
                    }
                }

                while (pos < pushSize && pushed[popSize] != popped[i]) {
                    // 循环的将pushed中的元素入栈
                    help.push(pushed[pos]);
                    pos++; // 如果pos = 3 的时候匹配， 那么只会入栈pos = 0, 1和2 的元素
                    if (pos >= pushSize) break;
                }
                // pos 跳过当前匹配元素 用因为紧接着就是i++ 相当于入栈又出栈的情况
                pos++;

            }
        }
        return true;
    }

    // 与方法一类似
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> help = new Stack<>();
        int pushSize = pushed.length, popSize = popped.length;
        int pos = 0;
        for (int i = 0; i < pushSize; i++) {
            help.push(pushed[i]);
            while (pos < popSize && !help.isEmpty() && help.peek() == popped[pos]) {
                help.peek();
                pos++;
            }
        }
        return help.isEmpty();
    }
}
