You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1

```cpp
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
    int totalSum = accumulate(nums.begin(), nums.end(), 0);
    // 간단하게 누적 합 구하는 함수 accumulate
    // 3번째 파라미터는 초기 시작 값임. 
    
    if ((totalSum - target) < 0 || (totalSum - target) % 2 != 0) {
        return 0;
    }
    
    int subsetSum = (totalSum - target) / 2;
    
    // DP vector to store the number of ways to achieve each sum
    vector<int> dp(subsetSum + 1, 0);
    // dp에는 subsetSum 까지의 모든 정보들을 저장해야하므로 +1 까지 저장
    dp[0] = 1; // Base case: one way to achieve sum 0 (empty subset)
    
    // Update DP array
    for (int num : nums) {
        for (int j = subsetSum; j >= num; --j) {
            dp[j] += dp[j - num];
        }
    }
    
    return dp[subsetSum];
}
};
```