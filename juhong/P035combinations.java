/** https://leetcode.com/problems/combinations/
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        comb(0, 0, new int[k], result, n);
        return result;
    }

    public void comb(int last, int index, int[] arr, List<List<Integer>> result, int n) {
        if (index == arr.length) {
            ArrayList<Integer> element = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                element.add(arr[i]);
            }
            result.add(element);
            return;
        }

        for (int i = last + 1; i <= n; i++) {
            arr[index] = i;
            comb(i, index + 1, arr, result, n);
        }

    }
}