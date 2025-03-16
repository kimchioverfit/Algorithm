/** https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

class Solution {

    public int search(int[] nums, int target) {        
        int k = 0;
        if (nums.length != 1) {
            k = pivot(nums, 0, nums.length - 1);
        }

        if (k - 1 >= 0 && nums[0] <= target && target <= nums[k - 1]) {
            return binary(nums, target, 0, k - 1);
        }
        else if (nums[k] <= target && target <= nums[nums.length - 1]) {
            return binary(nums, target, k, nums.length - 1);
        }
        return -1;
    }

    public int binary(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        else if (target < nums[mid]) {
            return binary(nums, target, start, mid - 1);
        }
        else {
            return binary(nums, target, mid + 1, end);
        }

    }

    public int pivot(int[] nums, int start, int end) {
        int mid = (start + end) / 2;

        int before = (mid - 1) < 0 ? (nums.length - 1) : (mid - 1);
        int next = (mid + 1) >= nums.length ? 0 : mid + 1;

        if (nums[mid] < nums[before] && nums[mid] < nums[next]) {
            return mid;
        }

        if (nums[start] < nums[end]) {
            return pivot(nums, start, mid - 1);
        }
        else {
            if (nums[start] <= nums[mid]) {
                return pivot(nums, mid + 1, end);
            }
            else {
                return pivot(nums, start, mid - 1);
            }
        }
    }
}