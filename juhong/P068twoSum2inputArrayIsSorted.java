/** https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 < numbers.length) {
                index = binary(numbers, target - numbers[i], i + 1, numbers.length - 1);
                if (index != -1) {
                    return new int[]{i + 1, index + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private int binary(int[] numbers, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (target == numbers[mid]) {
            return mid;
        }
        else if (target < numbers[mid]) {
            return binary(numbers, target, start, mid - 1);
        }
        else {
            return binary(numbers, target, mid + 1, end);
        }
    }
}