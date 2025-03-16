/** https://leetcode.com/problems/single-number/
 */

class Solution {
    public static final int THRESHOLD = 30000;

    public int singleNumber(int[] nums) {
        boolean[] bits = new boolean[6 * 10000 + 2];
        int min = THRESHOLD + 1;
        int max = -1;
        
        for (int num : nums) {
            num += THRESHOLD;
            bits[num] = bits[num] ? false : true;
            max = max < num ? num : max;
            min = min < num ? min : num;
        }

        for (int i = min; i <= max; i++) {
            if (bits[i]) {
                return i - THRESHOLD;
            }
        }
        return -1;
    }
}