---
layout: post
title: 704. Binary Search.md
category: leetcode
date: 2024-12-18 16:18:45 +0900
description: https://leetcode.com/problems/binary-search/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

            
# 704. Binary Search

Given an array of integers nums which is sorted in ascending order, 

and an integer target, write a function to search target in nums. 

If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4

Explanation: 9 exists in nums and its index is 4

    Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1

Explanation: 2 does not exist in nums so return -1

# Solution (Time ↑, Memory ↓)
```cpp
int init = [] {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ofstream out("user.out");
  cout.rdbuf(out.rdbuf());
  for (string s; getline(cin, s); cout << '\n') {
    string t;
    getline(cin, t);
    int tar = stoi(t);
    for (int i = 0, _i = 1, _n = s.length(); _i < _n; ++i, ++_i) {
      bool _neg = 0;
      if (s[_i] == '-')
        ++_i, _neg = 1;
      int v = s[_i++] & 15;
      while ((s[_i] & 15) < 10)
        v = v * 10 + (s[_i++] & 15);
      if (_neg)
        v = -v;
      if (v == tar) {
        cout << i;
        goto next;
      }
      if (v > tar)
        break;
    }
    cout << -1;
  next:;
  }
  exit(0);
  return 0;
}();

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int first = 0, last = nums.size() - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2; 
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                first = mid + 1; // Move to the right half
            } else {
                last = mid - 1; // Move to the left half
            }
        }
        return -1; // Target not found
    }
};
```
이 방식은 4ms 가 걸렸지만, Memory는 아래의 내 코드보다 4배 적게 사용함. (8MB)

상세한 내용은 찾아보자

# My Solution

```cpp
#include <vector>
using namespace std;
class Solution
{
public:
    int index = 0;
    int result = -1;
    int temp = 0;

    int search(vector<int>& nums, int target) 
    {
        if (nums.empty()) // nums가 비어있는지 확인
        {
            return -1;
        }

        index = nums.size() / 2;

        if (target == nums[index]) // 타겟 숫자와 중간 값이 같을 때
        {
            return index + temp;
        }

        if (target > nums[index]) // 타겟 숫자가 중간 값보다 클 때
        {
            vector<int> sliced_nums(nums.begin() + index + 1, nums.end());
            temp += index + 1;
            return search(sliced_nums, target);
        }

        // 타겟 숫자가 중간 값보다 작을 때
        vector<int> sliced_nums(nums.begin(), nums.begin() + index);
        return search(sliced_nums, target);
    }
};
```

원리를 알고 있으면 어려운 문제는 아니지만, 

index 사용에 있어서 실수가 많아서 Submit 을 여러 번 함. 