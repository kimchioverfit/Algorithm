/** https://leetcode.com/problems/binary-search/
 */

class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length - 1);
    }
    
    public int binary(int[] nums, int target, int first, int last) {
    	if (first > last) return -1;
    	int mid = (first + last) / 2;
    	
    	if (target == nums[mid]) {
    		return mid;
    	}
    	else if (target < nums[mid]) {
    		return binary(nums, target, first, mid - 1);
    	}
    	else {
    		return binary(nums, target, mid + 1, last);
    	}    	
    }
}