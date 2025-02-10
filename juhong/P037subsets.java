/** https://leetcode.com/problems/subsets/description/
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        comb(0, 0, nums, new int[nums.length], result);
        return result;
    }

    public void comb(int numIndex, int elementIndex, int[] nums, int[] element, List<List<Integer>> result) {
        if (elementIndex <= nums.length) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < elementIndex; i++) {
                ret.add(element[i]);
            }
            result.add(ret);
        }

        for (int i = numIndex; i < nums.length; i++) {
            element[elementIndex] = nums[i];
            comb(i + 1, elementIndex + 1, nums, element, result);
        }
        
    }
}