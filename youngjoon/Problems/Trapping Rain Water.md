---
layout: post
title: 42. Trapping Rain Water
category: leetcode
date: 2025-01-27 12:27:00 +0900
description: https://leetcode.com/problems/trapping-rain-water/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

# 42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

<img src="imgs/rainwatertrap.png" alt="heap_1" width="500"/>'

```
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

```
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
```

# Solution (Two pointer)

```cpp
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            // 왼쪽 벽이 오른쪽 벽보다 낮은 경우
            if (height[left] < height[right]) {
                // 현재 왼쪽 벽이 왼쪽 최대 높이보다 높으면 업데이트
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // 아니면 물을 채움
                    trappedWater += (leftMax - height[left]);
                }
                left++;
            }
            // 오른쪽 벽이 왼쪽 벽보다 낮거나 같은 경우
            else {
                // 현재 오른쪽 벽이 오른쪽 최대 높이보다 높으면 업데이트
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // 아니면 물을 채움
                    trappedWater += (rightMax - height[right]);
                }
                right--;
            }
        }

        return trappedWater;
    }
};
```
Two pointer를 이용한 풀이, 
시간 복잡도 : O(N)
공간 복잡도 : O(1)


DP를 이용해서도 풀 수 있다. 


# Solution2 (DP)

```cpp
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        if (n == 0) return 0; // 빈 배열이면 0 반환

        // 왼쪽 최대 높이를 저장하는 배열
        vector<int> leftMax(n, 0);
        // 오른쪽 최대 높이를 저장하는 배열
        vector<int> rightMax(n, 0);

        // 왼쪽 최대 높이 계산
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = max(leftMax[i - 1], height[i]);
        }

        // 오른쪽 최대 높이 계산
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = max(rightMax[i + 1], height[i]);
        }

        // 각 인덱스에서 물의 양 계산
        int totalWater = 0;
        for (int i = 0; i < n; ++i) {
            int waterAtCurrent = min(leftMax[i], rightMax[i]) - height[i];
            if (waterAtCurrent > 0) {
                totalWater += waterAtCurrent;
            }
        }

        return totalWater;
    }
};
```

시간 복잡도 : O(N)
공간 복잡도 : O(N)