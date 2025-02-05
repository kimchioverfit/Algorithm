/** 15. 3Sum
 https://leetcode.com/problems/3sum/
 */

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            if ( i > 0 && nums[i - 1] == nums[i] ) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int start = i + 1;
            int end = length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && (nums[start] == nums[start + 1]) ) {
                        start += 1;
                    }
                    while (start < end && (nums[end] == nums[end - 1]) ) {
                        end -= 1;
                    }
                    start += 1;
                    end -= 1;
                }
                else if (sum > 0) {
                    end -= 1;
                }
                else {
                    start += 1;
                }
            }

        }

        return result;
    }
}