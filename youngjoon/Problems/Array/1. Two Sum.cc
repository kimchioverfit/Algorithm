#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {
public:
    // Solution 1
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> num_map;
        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];
            if (num_map.find(complement) != num_map.end()) {
                return {num_map[complement], i};
            }
            num_map[nums[i]] = i;
        }
        return {};
    }
};

class Solution {
public:
    // Solution 2
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> sortedNums;
        for (int i = 0; i < nums.size(); ++i) {
            sortedNums.push_back({nums[i], i});
        }

        sort(sortedNums.begin(), sortedNums.end());

        int left = 0;
        int right = sortedNums.size() - 1;

        while (left < right) {
            int sum = sortedNums[left].first + sortedNums[right].first;
            if (sum == target) {
                return {sortedNums[left].second, sortedNums[right].second};
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        
        return {};
    }
};