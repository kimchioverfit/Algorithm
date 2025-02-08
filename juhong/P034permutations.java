/** https://leetcode.com/problems/permutations/
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	perm(0, new int[nums.length], nums, new boolean[nums.length], result);
    	
		return result;
    }

    public void perm(int index, int[] element, int[] nums, boolean[] used, List<List<Integer>> result) {
    	if (index == nums.length) {
    		ArrayList<Integer> r = new ArrayList<Integer>();
    		for (int e : element) {
    			r.add(e);
    		}
    		result.add(r);
    		return;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (!used[i]) {
    			used[i] = true;
    			element[index] = nums[i];
    			perm(index + 1, element, nums, used, result);
    			used[i] = false;
    		}
    	}    	
    }    
}