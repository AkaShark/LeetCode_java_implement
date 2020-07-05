package 链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Mid_82_删除排序链表中的重复元素II {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 有点不好 复杂
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while (head != null) {
            Integer num = map.get(head.val);
            System.out.println(num);
            if (num == null) {
                num = 1;
            } else {
                num++;
            }
            map.put(head.val, num);
            head = head.next;
        }
        ListNode node = dummy;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!(entry.getValue() > 1)) {
                node.next = new ListNode(entry.getKey());
                node = node.next;
            }
            node.next = null;
        }
        return dummy.next;
    }

    //    LeetCode 利用了有序 没啥可说的很简单
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode cur = dummy;
//        while (cur.next != null && cur.next.next != null) {
//            if (cur.next.val == cur.next.next.val) {
//                ListNode temp = cur.next;
//                while (temp != null && temp.next != null && temp.val == temp.next.val) {
//                    temp = temp.next;
//                }
//                cur.next = temp.next;
//            } else
//                cur = cur.next;
//        }
//        return dummy.next;
//    }

}
