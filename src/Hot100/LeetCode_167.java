package Hot100;

public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            if (numbers[left] + numbers[right] > target) {
                right --;
            } else if (numbers[left] + numbers[right] < target) {
                left ++;
            } else {
                break;
            }
        }
        return new int[]{left, right};
    }
}
