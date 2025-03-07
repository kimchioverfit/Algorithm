# [문제](https://leetcode.com/problems/find-the-duplicate-number/description/)

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:

> Input: nums = [1,3,4,2,2]

> Output: 2


Example 2:

> Input: nums = [3,1,3,4,2]

> Output: 3


Example 3:

> Input: nums = [3,3,3,3,3]

> Output: 3


Constraints:

- 1 <= n <= 10^5
- nums.length == n + 1
- 1 <= nums[i] <= n
- All the integers in nums appear only once except for precisely one integer which appears two or more times.


# 풀이
배열에서 중복으로 나오는 숫자가 있으면 해당 숫자를 찾으면 된다.

처음에는 set으로도 중복 체크를 해보고, 정렬해서 중복 체크도 해봤지만 성능이 안 나와서 어떻게 해야하나 고민했는데 문제를 자세히 읽어보니 해답이 보였다.

이 두 줄 덕분에 중복이 존재하는지 체크할 수 있는 boolean 배열을 선언하여 풀었다.
- nums.length == n + 1
- 1 <= nums[i] <= n