# [문제](https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/)

You are given an m x n integer matrix grid.

We define an hourglass as a part of the matrix with the following form:

Return the maximum sum of the elements of an hourglass.

Note that an hourglass cannot be rotated and must be entirely contained within the matrix.


Example 1:

Input: 
> grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]

Output: 
> 30

Explanation: 
> The cells shown above represent the hourglass with the maximum sum: 6 + 2 + 1 + 2 + 9 + 2 + 8 = 30.

Example 2:

Input:
> grid = [[1,2,3],[4,5,6],[7,8,9]]

Output: 
> 35

Explanation:
> There is only one hourglass in the matrix, with the sum: 1 + 2 + 3 + 5 + 7 + 8 + 9 = 35.


Constraints:
- m == grid.length
- n == grid[i].length
- 3 <= m, n <= 150
- 0 <= grid[i][j] <= 106


# 풀이
배열에서 대문자 I 모양을 선택했을 때, 해당하는 숫자의 합이 가장 큰 것을 찾는 문제이다.

단순하게 이중 for문으로 더했는데도 타임아웃이 발생하지 않았다.

다른 방법이 있나 Solutions를 찾아봤는데도 다 같은 방식인걸 보면 더 좋은 방법은 없나보다.

> Runtime
9 ms
Beats
66.67%