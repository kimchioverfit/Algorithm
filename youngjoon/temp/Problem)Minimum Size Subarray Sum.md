209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

```cpp
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
    int n = nums.size();
    int left = 0, sum = 0;
    int minLength = INT_MAX;

    for (int right = 0; right < n; ++right) {
        sum += nums[right];

        // Shrink the window as small as possible while the sum is >= target
        while (sum >= target) {
            minLength = min(minLength, right - left + 1);
            sum -= nums[left];
            ++left;
        }
    }

    return (minLength == INT_MAX) ? 0 : minLength;
}
};
```
sliding window