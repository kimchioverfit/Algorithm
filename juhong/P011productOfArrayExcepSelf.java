/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] a = new int[length];
        int[] b = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = 1;
            b[i] = 1;
        }
        a[0] = nums[0];
        b[length - 1] = nums[length - 1];

        for (int cur = 0; cur < nums.length; cur++) {
            int before = cur - 1;
            if (before >= 0) {
                a[cur] *= a[before] * nums[cur];
            }

            int after = (length - 1) - (cur - 1);
            if (after < length) {
                b[(length - 1) - cur] *= b[after] * nums[(length - 1) - cur];
            }
        }


        for (int i = 0; i < nums.length; i++) {
            int start = i - 1;
            int end = i + 1;

            int element = 1;
            if (start >= 0) {
                element *= a[start];
            }
            if (end < length) {
                element *= b[end];
            }
            result[i] = element;
        }
        return result;
    }
}