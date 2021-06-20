package Hot100;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode_137 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    /*
    * 给你一个整数数组nums,
    * 除某个元素仅出现一次外，
    * 其余每个元素都恰出现三次.
    * 请你找出并返回那个只出现了一次的元素。*/
    // hash表处理
    public int singleNumber_1(int[] nums) {
        HashMap<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i : nums) {
            map.put(i, !map.containsKey(i));
        }

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()){
            if (entry.getValue()) return entry.getKey();
        }
        return -1;
    }

}
