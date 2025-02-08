# [문제](https://leetcode.com/problems/peak-index-in-a-mountain-array/description/)

You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
Return the index of the peak element.
Your task is to solve it in O(log(n)) time complexity.

Example 1:
Input:
> arr = [0,1,0]
Output:
> 1
> 
Example 2:
> 
Input:
> arr = [0,2,1,0]
Output:
> 1

Example 3:
Input: 
> arr = [0,10,5,2]
Output:
> 1

Constraints:
- 3 <= arr.length <= 105
- 0 <= arr[i] <= 106
- arr is guaranteed to be a mountain array.

# 풀이
배열 내에서 가장 큰 숫자가 위치한 곳의 index를 찾는 문제이다.

O(log(n)) 타임 내에 찾아야 하기 때문에 투포인터를 이용하여 중간에서부터 찾아나갔다.
