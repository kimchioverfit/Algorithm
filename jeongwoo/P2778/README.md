# [문제](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

You are given a 1-indexed integer array nums of length n.

An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.

Return the sum of the squares of all special elements of nums.



Example 1:

> Input: nums = [1,2,3,4]

> Output: 21

> Explanation: There are exactly 3 special elements in nums: nums[1] since 1 divides 4, nums[2] since 2 divides 4, and nums[4] since 4 divides 4.
Hence, the sum of the squares of all special elements of nums is nums[1] * nums[1] + nums[2] * nums[2] + nums[4] * nums[4] = 1 * 1 + 2 * 2 + 4 * 4 = 21.  

Example 2:

> Input: nums = [2,7,1,19,18,3]

> Output: 63

> Explanation: There are exactly 4 special elements in nums: nums[1] since 1 divides 6, nums[2] since 2 divides 6, nums[3] since 3 divides 6, and nums[6] since 6 divides 6.
Hence, the sum of the squares of all special elements of nums is nums[1] * nums[1] + nums[2] * nums[2] + nums[3] * nums[3] + nums[6] * nums[6] = 2 * 2 + 7 * 7 + 1 * 1 + 3 * 3 = 63.

# 풀이
인덱스가 1부터 시작하는 정수 배열이 주어졌을 때, 배열의 크기 n이 인덱스 i로 나눠지는 경우 해당 인덱스의 원소의 제곱의 합을 구하는 문제 