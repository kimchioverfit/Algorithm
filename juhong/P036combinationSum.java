/** https://leetcode.com/problems/combination-sum/description/
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        comb(result, new int[41], 0, 0, 0, candidates, target);
        return result;
    }

    public void comb(List<List<Integer>> result, int[] element, int index, int lastIndex, int sum, int[] candidates, int target) {
        if (sum == target) {
            ArrayList<Integer> ret = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                ret.add(element[i]);
            }
            result.add(ret);
            return;
        }

        for (int i = lastIndex; i < candidates.length; i++) {
            if (candidates[i] + sum > target) {
                break;
            }
            element[index] = candidates[i];
            comb(result, element, index + 1, i, candidates[i] + sum, candidates, target);
            element[index] = 0;
        }
    }
}