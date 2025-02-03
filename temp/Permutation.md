### permutation

```cpp
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> results;
        vector<int> current;
        vector<bool> used(nums.size(), false);
        backtrack(nums, results, current, used);
        return results;
    }

private:
    void backtrack(vector<int>& nums, vector<vector<int>>& results, vector<int>& current, vector<bool>& used) {
        if (current.size() == nums.size()) {
            results.push_back(current);
            return;
        }
        
        for (int i = 0; i < nums.size(); ++i) {
            if (used[i]) continue;
            used[i] = true;
            current.push_back(nums[i]);
            backtrack(nums, results, current, used);
            current.pop_back();
            used[i] = false;
        }
    }
};
```

