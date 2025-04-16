/** https://leetcode.com/problems/maximum-subarray/
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int start = 0;
        int end = 0;
        
        while (true) {
        	while (cur < 0) {
        		if (start < end) {
            		cur -= nums[start];        			
        		}
        		start += 1;
        	}
        	if (start > end) {
        		end = start;        		
        	}
        	if (end >= nums.length) {
        		break;
        	}
        	
        	cur += nums[end];
        	if (cur > max) {
        		max = cur;
        	}
        	end += 1;        	
        }        
        
        return max;
    }
}