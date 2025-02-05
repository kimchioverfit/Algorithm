/** 561. Array Partition
 https://leetcode.com/problems/array-partition/
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        ArrayList<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            numList.add(num);
        }
        Collections.sort(numList);
        for (int i = 0; i < numList.size(); i += 2) {
            result += numList.get(i);
        }
        return result;
    }
}