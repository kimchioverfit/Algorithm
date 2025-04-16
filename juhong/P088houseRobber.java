/** https://leetcode.com/problems/house-robber/
 */

class Solution {
    public static int[] max = null; 
    public int rob(int[] nums) {
        max = new int[nums.length];
        Arrays.fill(max, -1);
        
        int left = getMax(nums.length - 1, nums);
        int right = (nums.length >= 2 ? getMax(nums.length - 2, nums) : 0);

        return (left > right ? left : right);
    }

    public int getMax(int i, int[] nums) {

        if (max[i] > -1) {
            return max[i];
        }

        int two = nums[i] + (i >= 2 ? getMax(i - 2, nums) : 0);
        int three = nums[i] + (i >= 3 ? getMax(i - 3, nums) : 0);

        max[i] = two > three ? two : three;
        return max[i];
    }

    // [2, 6, 7, 1, 1, 10, 2, 1]
}