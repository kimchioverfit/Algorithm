---
layout: post
title: 15. 3Sum.md
category: leetcode
date: 2024-12-18 16:18:45 +0900
description: https://leetcode.com/problems/3sum/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

            
# 15. 3Sum


Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 
```
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
```

Notice that the order of the output and the order of the triplets does not matter.
```
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```
```
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
```


### 1차 도전

```cpp
class Solution {
public:
vector<vector<int>> results;
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        for (int i=1; i<nums.size(); i++){
            int left = i-1;
            int right = i+1;
            while(left < i && i < right && 0<= left && right<nums.size()){
                if (nums[left]+nums[i]+nums[right]==0){
                    vector<int> temp;
                    temp.push_back(nums[left]);
                    temp.push_back(nums[i]);
                    temp.push_back(nums[right]);
                    results.push_back(temp);
                    break;
                }
                else if  (nums[left]+nums[i]+nums[right]<0){
                    right++;
                }
                else if  (nums[left]+nums[i]+nums[right]>0){
                    left--;
                }
            }
        }
        return results;
    }
};

```
위 코드는 인풋이 아래와같을 때  
```
nums = [0,0,0,0]
```
아웃풋이 아래와 같이 나오게 되어 오답.
```
[[0,0,0],[0,0,0]]
```
아웃풋은 중복 없이 
```
[[0,0,0]]
```
위와 같이 나와야 함.

### 2차 도전

```cpp
class Solution {
public:
vector<vector<int>> results;
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        for (int i=1; i<nums.size(); i++){
            int left = i-1;
            int right = i+1;
            while(left < i && i < right && 0<= left && right<nums.size()){
                if (nums[left]+nums[i]+nums[right]==0){
                    vector<int> temp;
                    temp.push_back(nums[left]);
                    temp.push_back(nums[i]);
                    temp.push_back(nums[right]);
                    results.push_back(temp);
                    left--; //변경된 부분
                }
                else if  (nums[left]+nums[i]+nums[right]<0){
                    right++;
                }
                else if  (nums[left]+nums[i]+nums[right]>0){
                    left--;
                }
            }
        }
        set<vector<int>> s(results.begin(), results.end());
        vector<vector<int>> results(s.begin(), s.end());
        return results;
    }
};

```
바로 break 했더니 중심은 같은데 좌우가 다른 경우를 못찾았음.
그래서 추가로 탐지 가능하게 변경

하지만 인풋이 
```
[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.....,0]
```
위와 같은 경우에는 대처하지 못했음.

### 3차도전

```cpp
class Solution {
public:
vector<vector<int>> results;
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        for (int i=1; i<nums.size(); i++){
            int left = i-1;
            int right = i+1;
            while(left < i && i < right && 0<= left && right<nums.size()){
                if (nums[left]+nums[i]+nums[right]==0){
                    results.push_back({nums[left],nums[i],nums[right]});//달라진 부분 
                    left--; 
                }
                else if  (nums[left]+nums[i]+nums[right]<0){
                    right++;
                }
                else if  (nums[left]+nums[i]+nums[right]>0){
                    left--;
                }
            }
        }
        set<vector<int>> s(results.begin(), results.end());
        vector<vector<int>> results(s.begin(), s.end());
        return results;
    }
};
```
temp를 만들고 다시 results에 넣는 걸 생략해서 겨우 통과할 수 있었음.
(시간 효율성은 극악임)

### 제대로 된 풀이 

```cpp
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> results;
        if (nums.size() < 3) return results;

        sort(nums.begin(), nums.end());
        
        for (int i = 0; i < nums.size() - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //nums[i]중복제거
            
            int left = i + 1, right = nums.size() - 1; //i,left,right순
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    results.push_back({nums[i], nums[left], nums[right]});
                    
                    // 중복된 값 피하기
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return results;
    }
};
```

우선 index를 0부터 시작하고, left, right의 시작 위치가 다름.

i를 첫 번째 값으로, left를 중간 값으로, right를 마지막 값으로 이용함. 

