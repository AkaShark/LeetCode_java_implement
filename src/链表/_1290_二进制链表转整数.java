package 链表;

public class _1290_二进制链表转整数 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int getDecimalValue(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node!=null){
            node = node.next;
            len++;
        }
        node = head;
        int sum = 0;
        while (node!=null){
            sum += node.val*Math.pow(10,len);
            System.out.println(sum);
            len--;
        }
        return sum;
    }
//    Leetcode
//        public int getDecimalValue(ListNode head) {
//        int result = 0;
//        while(head!=null){
//        // 逆运算 乘以2再加上余数
//            result = result*2;
//            result += head.val;
//            head = head.next;
//        }
//        return result;
//    }
}
