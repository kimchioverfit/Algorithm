/** 1. Two Sum
https://leetcode.com/problems/two-sum/
 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;

        for (int i = 0; i < nums.length; i++) { /* O(n) */
            num = nums[i];
            if (map.containsKey(num)) { /* O(1) */
                return new int[]{i, map.get(num)};  /* O(1) */
            }
            else {
                map.put(target - nums[i], i);  /* O(1) */
            }
        }
        return new int[]{};
    }
}