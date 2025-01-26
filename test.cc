#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int findTargetSumWays(vector<int>& nums, int target) {
    int totalSum = accumulate(nums.begin(), nums.end(), 0);
    
    // If the target sum is not achievable or invalid
    if ((totalSum - target) < 0 || (totalSum - target) % 2 != 0) {
        return 0;
    }
    
    int subsetSum = (totalSum - target) / 2;
    
    // DP vector to store the number of ways to achieve each sum
    vector<int> dp(subsetSum + 1, 0);
    dp[0] = 1; // Base case: one way to achieve sum 0 (empty subset)
    
    // Update DP array
    for (int num : nums) {
        for (int j = subsetSum; j >= num; --j) {
            dp[j] += dp[j - num];
        }
        cout<< "d"<<endl;
    }
    
    return dp[subsetSum];
}

int main() {
    vector<int> nums = {1, 1, 2, 2, 2,3,3,6};
    int target = 6;
    
    cout << "Number of ways to achieve target: " << findTargetSumWays(nums, target) << endl;
    return 0;
}
