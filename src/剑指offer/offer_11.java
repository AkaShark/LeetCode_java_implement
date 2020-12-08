package 剑指offer;

public class offer_11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return -1;
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexRes = index1;

        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexRes = index2;
                break;
            }
            int middle = (index1 + index2) >>> 1;
            // 如果小标为index1 index2 和middle 指向的三个数都一样的话没法确定middle属于那个子序列 只能顺序查找
            if (numbers[index1] == numbers[index2] && numbers[middle] == numbers[index1]) {
                return MinInOrder(numbers, index1, index2);
            }

            if (numbers[index1] <= numbers[middle]) index1 = middle;
            else if (numbers[index2] >= numbers[middle]) index2 = middle;

        }
        return numbers[indexRes];
    }

    public int MinInOrder(int[] nums, int index1, int index2) {
        // 假设最小值为index1
        int result = nums[index1];

        for (int i = index1 + 1; i <= index2; i++) {
            if (result > nums[i]) result = nums[i];
        }

        return result;
    }
}
