package 链表;

public class Mid_2_两数相加 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//    思路不对 这么相加的话数字溢出来

    //    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long num1 = numOfLinklist(l1);
//        long num2 = numOfLinklist(l2);
//        double sum = num1+num2;
//        ListNode node = new ListNode(0);
//        ListNode temp = node;
////        如果sum为0的话
//        if (sum == 0){
//            node.next = new ListNode(0);
//            return node.next;
//        }
//
//        while (sum!=0){
//            int val = (int)sum % 10;
//            ListNode cur = new ListNode(val);
//            temp.next = cur;
//            temp = temp.next;
//            sum = sum/10;
//        }
//        return node.next;
//    }
//    static public long numOfLinklist(ListNode node){
//        long num = 0,i = 0;
////        求和
//        while (node!=null){
//            num += node.val*Math.pow(10,i);
//            i++;
//            node = node.next;
//        }
//        return num;
//    }
// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        我的思路 但代码复用太低了 好多可以复用的地方
//        ListNode node = new ListNode(0);
//        ListNode cur = node;
//        int sum =0,temp=0;
//        while (l1!=null&&l2!=null){
//            sum = l1.val+l2.val+temp;
//            temp=0;
//            if (sum/10!=0){
//                sum = sum%10;
//                temp++;
//            }
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            sum=0;
//            l1= l1.next;
//            l2 = l2.next;
//        }
//        while (l1!=null){
//            sum = l1.val+temp;
//            temp=0;
//            if (sum/10!=0){
//                sum = sum%10;
//                temp++;
//            }
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            l1 = l1.next;
//        }
//
//        while (l2!=null){
//            sum = l2.val+temp;
//            temp=0;
//            if (sum/10!=0){
//                sum = sum%10;
//                temp++;
//            }
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            l2 = l2.next;
//        }
//        if (temp!=0){
//            cur.next = new ListNode(1);
//        }
//        return node.next;
//    }


    //    LeetCode---1 我的思路的简化代码版 值得学习
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int t = 0;
////        头结点
//        ListNode dummy = new ListNode(-1);
//        ListNode pre = dummy;
//        while (l1 != null || l2 != null || t != 0) {
//            if (l1 != null) {
//                t += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                t += l2.val;
//                l2 = l2.next;
//            }
//            pre.next = new ListNode(t % 10);
//            t /= 10;
//            pre = pre.next;
//        }
//        return dummy.next;
//    }
//
//
//    Leetcode---2 简化思路差不多 用0和add 标记是否做处理
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode(0);
        ListNode head3 = result;

        boolean isAdd = false;
        while (head1!=null || head2!=null){
            int x =(head1!=null)? head1.val : 0;
            int y =(head2!=null)? head2.val : 0;
            int sum = (isAdd)?(x+y+1):(x+y);
            if(sum>=10){
                sum-=10;
                isAdd=true;
            }else{
                isAdd=false;
            }
            head3.next = new ListNode(sum%10);
            head3 = head3.next;
            head1 = (head1!=null)? head1.next:null;
            head2 = (head2!=null)? head2.next:null;
        }

//        最后一个节点
        if(isAdd){
            head3.next = new ListNode(1);
        }
        return result.next;
    }

//    public static void main(String[] args) {
//        ListNode node = new ListNode(2);
//        node.next = new ListNode(4);
//        node.next.next = new ListNode(3);
//
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);
//
//        addTwoNumbers(node, node2);
//
//
//    }
}

