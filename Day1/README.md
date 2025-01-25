# [문제](https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/)

Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.

Test cases are generated such that partitioning exists.

Example 1:

Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

Constraints:

- 2 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^6
- There is at least one valid answer for the given input.

# 풀이
인덱스 X를 기준으로 Left, Right 배열을 나눴을때 Left 배열 내 최댓값이 Right에 있는 모든 수보다 작거나 같은 경우 정답을 반환했다.

nums의 length가 작기 때문에 이중 for문으로도 해결이 가능했던거 같은데, 숫자가 더 많다면 다른 방법으로 접근하는 것이 좋아보인다.