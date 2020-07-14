package 看视频练习的;

import java.util.PriorityQueue;
// 使用了java PriorityQueue
//class KthLargest {
//    private PriorityQueue<Integer> queue;
//    private int limit;
//
//    public KthLargest(int k, int[] nums) {
//        limit = k;
//        queue = new PriorityQueue<>(k);
//        for (int num : nums) {
//            add(num);
//        }
//
//    }
//
//    // 两种情况可以add进来 ① 优先队列不满（优先队列中的元素个数小于K） ② 添加进来的val的大小大于优先队列中最小的元素 ps： 优先队列 PriorityQueue的实现是利用了小顶堆
//    public int add(int val) {
//        if (queue.size() < limit) {
//            queue.add(val);
//        } else if (val > queue.peek()) {
//            queue.poll();
//            queue.add(val);
//        }
//        return queue.peek();
//    }
//}

// LeetCode的解法 自己手动构造维护了一个小顶堆
class KthLargest {

    /**小顶堆*/
    private int[] minHeap;
    /**堆的规模*/
    private final int k;
    /**堆的最后一个元素的索引*/
    private int last;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new int[k+1];
        /**进入堆*/
        for (int i = 1; i <= k && i <= nums.length; i++){
            this.minHeap[i] = nums[i-1];
            this.last = i;
        }

        /*如果小顶堆被填满了,就继续添加元素,并使堆有序*/
        if (last == k) {
            order();
            for (int i = k; i < nums.length; i++){
                add(nums[i]);
            }
        }

    }

    public int add(int val) {
        /*如果堆还未被填满（由题意堆会在至多一次add后被填满）,则将元素放在无序堆的末尾，然后将堆有序化*/
        if (last == k-1) {
            minHeap[++last] = val;
            order();
        }
        /*如果新元素大于堆中第k大的元素（minHeap[1]），则替换它，并将堆有序化*/
        else if(val > minHeap[1]){
            minHeap[1] = val;
            /* 排序 此时处堆尖处无序外,其他部分为有序,所以只需将堆顶下沉即可*/
            sink(1);
        }
        /*第K大的元素*/
        return minHeap[1];
    }

    /**堆的有序化*/
    private void order(){
        /*K 是堆的大小 i是最后一个非叶子节点*/
        for (int i = k/2; i >=1 ; i--) {
            sink(i);
        }
    }

    /**下沉 小顶堆*/
    private void sink(int i) {
        /* 2*i 为子节点  */
        while( 2*i <= k){
            int j = 2*i;
            /* 左右节点选择最大的节点 */
            if ( j < k && minHeap[j] > minHeap[j+1]) {
                j++;
            }
            /* 堆顶元素大于子节点 交换 */
            if ( minHeap[i] > minHeap[j]) {
                int temp = minHeap[i];
                minHeap[i] = minHeap[j];
                minHeap[j] = temp;

                i = j; // 继续向下找
            } else {
                break;
            }
        }
    }
}

