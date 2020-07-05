package 链表;

public class Mid_725_分隔链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //    public ListNode[] splitListToParts(ListNode root, int k) {
////        ListNode[] result = new ListNode[k];
////        int len = 0;
////        ListNode cur = root;
//////        求长度
////        while (cur!=null){
////            cur = cur.next;
////            len++;
////        }
////        cur = root;
//////        平均长度 和 长度加1的子表个数
////        int ava = len/k, rem = len%k;
////        for (int i = 0; i < k; i++) {
//////
////            if (cur == null) return result;
////            int width = ava;
////            ListNode dummy = new ListNode(0);
////            ListNode head = dummy;
//////            子链表的长度 平均加上是否是过长链表 （因为题目要求前面的长度大于后面的长度）
////            for (int j = 0; j<(width+(i<rem?1:0)) ; j++){
////                head.next = new ListNode(cur.val);
////                head = head.next;
////                cur = cur.next;
////            }
////            result[i] = dummy.next;
////        }
////        return result;
////    }

//    不新建链表 直接在原链表上修改指针
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = root;
        int ava = len / k, rem = len % k;
        ListNode next;
        for (int i = 0; i < k; i++) {
            ListNode temp_cur = cur;
//            这里与上面比减一是因为没有虚拟头上来就next了 第一个本来就在了
            for (int j = 0; j < (ava + (i < rem ? 1 : 0))-1; j++) {
                if (cur == null) return result;
                cur = cur.next;
            }
            if (cur!=null){
                next = cur.next;
                cur.next = null;
                cur = next;
            }
            result[i] = temp_cur;
        }
        return result;
    }

}
// LeetCode 版本思路同上
//class Solution {
//    public ListNode[] splitListToParts(ListNode root, int k) {
//        ListNode cur = root;
//        int N = 0;
//        while (cur != null) {
//            cur = cur.next;
//            N++;
//        }
//
//        int width = N / k, rem = N % k;
//
//        ListNode[] ans = new ListNode[k];
//        cur = root;
//        for (int i = 0; i < k; ++i) {
//            ListNode head = new ListNode(0), write = head;
//            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
//                write = write.next = new ListNode(cur.val);
//                if (cur != null) cur = cur.next;
//            }
//            ans[i] = head.next;
//        }
//        return ans;
//    }
//}
    //C++
// 他这个和上面的差不多 就是多余rem的理解与使用 上面的是根据i和rem 大小 这个是让rem-- rem为0 长度就不加1了
//class Solution {
//public:
//    //思路：先求出链表的长度，然后求出链表的平均长度，以及余数。由于题目规定任意两部分的长度不能超过1，所以余数依次给排在前面的平均长度+1即可
//    vector<ListNode*> splitListToParts(ListNode* root, int k) {
//        int size=0;
//        ListNode *p=root;
//        while(p){
//            size++;
//            p=p->next;
//        }
//        int avg_size=size/k,mod=size%k;
//        vector<ListNode*> res(k,nullptr);
//        ListNode *cur=root,*pre=nullptr;
//        for(int i=0;i<k;++i)
//        {
//            res[i]=cur;
//            //mod为0时，即使平均长度为0，cur为nullpre，不能实现断链了，即添加为nullptr
//            int temp_size=mod?(avg_size+1):avg_size;
//            while(temp_size--){
//                pre=cur;
//                cur=cur->next;
//            }
//            //pre为cur的前驱节点，也就是当前长度的最后一个节点，作用是实现断链
//            if(pre)pre->next=nullptr;
//            if(mod)mod--;
//        }
//        return res;
//    }
//};

