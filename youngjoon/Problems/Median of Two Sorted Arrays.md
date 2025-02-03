---
layout: post
title: 4. Median of Two Sorted Arrays.md
category: leetcode
date: 2024-12-18 16:18:45 +0900
description: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

            
# 4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, 

return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).


    Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000

Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000

Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.



## Binary search

단계

1. 작은 배열에 이진 탐색 수행 보장 
   - 두 배열 중 작은 배열에서 이진 탐색을 수행하는 것이 효율적입니다. 이는 연산량을 줄이기 위한 것입니다. 따라서 nums1의 크기가 nums2의 크기보다 크다면 두 배열을 교환합니다.

2. 이진 탐색 초기화
   - 이진 탐색의 경계를 low와 high로 설정합니다. 초기값은 low = 0이고, high = nums1.size()입니다.

3. 루프 내에서 이진 탐색 수행
   - 이진 탐색은 low가 high보다 작거나 같은 동안 계속됩니다.

4. partitionX와 partitionY 계산
   - partitionX는 nums1의 중간 지점을 의미합니다. (low + high) / 2로 계산됩니다.
partitionY는 (x + y + 1) / 2 - partitionX로 계산됩니다. 이는 전체 길이의 절반에서 partitionX를 뺀 값입니다. 이때, x와 y는 각 배열의 길이입니다.

5. 경계 값 설정
   - maxX는 partitionX의 왼쪽 값 중 최대값입니다. partitionX가 0인 경우에는 INT_MIN을 사용합니다. minX는 partitionX의 오른쪽 값 중 최소값입니다. partitionX가 배열의 끝이라면 INT_MAX를 사용합니다. maxY와 minY 역시 동일한 방식으로 partitionY에 대해 설정합니다.

6. 조건 검사
   - maxX <= minY 그리고 maxY <= minX인 경우, 올바른 partition을 찾은 것입니다. 이 경우 전체 길이가 짝수인지 홀수인지 판단하여 중간 값을 반환합니다.
     - 짝수인 경우: (max(maxX, maxY) + min(minX, minY)) / 2
     - 홀수인 경우: max(maxX, maxY)
   - maxX > minY인 경우
     - high를 partitionX - 1로 업데이트합니다. 이는 partitionX가 너무 오른쪽에 있음을 의미합니다.
   - maxY > minX인 경우
     - low를 partitionX + 1로 업데이트합니다. 이는 partitionX가 너무 왼쪽에 있음을 의미합니다.


### Binary search에서 nums1 num2 교환하는 이유:

**이진 탐색 기반 알고리즘의 작동 원리**

중간 값을 찾기 위해 이진 탐색을 사용하는 알고리즘은 다음과 같은 절차를 따릅니다.

<u>이진 탐색은 일반적으로 더 작은 배열을 기준</u>으로 수행하여 탐색 구간을 최소화하려고 합니다.

(이진 탐색은 배열의 요소를 절반씩 줄여 나가면서 검색하기 때문에, 더 작은 배열에서 이진 탐색을 수행하는 것이 더 효율적)

작은 배열의 "적절한 위치"를 찾기 위해서 이진 탐색을 수행하여 

그 기준으로 반대편 배열에서의 "적절한 위치"를 계산합니다.

이진 탐색을 통해 두 배열에서 합쳐서 "중간"에 위치하는 요소를 찾게 됩니다.


```cpp
#include <vector>
using namespace std;

double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    if (nums1.size() > nums2.size()) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    int x = nums1.size();
    int y = nums2.size();
    
    int low = 0, high = x;
    
    while (low <= high) {
        int partitionX = (low + high) / 2;
        int partitionY = (x + y + 1) / 2 - partitionX;
        
        int maxX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
        int minX = (partitionX == x) ? INT_MAX : nums1[partitionX];
        
        int maxY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
        int minY = (partitionY == y) ? INT_MAX : nums2[partitionY];
        
        if (maxX <= minY && maxY <= minX) {
            if ((x + y) % 2 == 0) {
                return (double)(max(maxX, maxY) + min(minX, minY)) / 2;
            } else {
                return (double)max(maxX, maxY);
            }
        } else if (maxX > minY) {
            high = partitionX - 1;
        } else {
            low = partitionX + 1;
        }
    }
}
```


---

### My solution

제한시간 안에는 풀리지만 최적의 방법은 아님.

> sort(temp.begin(), temp.end());

vector sort 하는 방법 순간 잊었었음. 주의 할 것.

> static_cast<double>(temp[index])

type casting 하는 방법도 잊었었음. 주의 할 것.

```cpp
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        double result = 0;
        int index = 0;
        vector<int> temp;
        for (auto element:nums1){
            temp.push_back(element);
        }
        for (auto element:nums2){
            temp.push_back(element);
        }
        sort(temp.begin(), temp.end()); // 기억해두자 vectort sort하는 방법 까먹었음
        if (temp.size()%2 ==0){
            index = temp.size()/2 - 1;
            result = (static_cast<double>(temp[index]) + static_cast<double>(temp[index+1]))/2 ; //이걸까먹음static_cast<double>;
            cout << result << endl;
        } 
        else{
            index = temp.size()/2;
            result = temp[index];
        }
        
        return result;
    }
};
```
