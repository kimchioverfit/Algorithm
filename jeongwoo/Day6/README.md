# [문제](https://leetcode.com/problems/check-balanced-string/description/)

You are given a string num consisting of only digits. A string of digits is called balanced if the sum of the digits at even indices is equal to the sum of digits at odd indices.
Return true if num is balanced, otherwise return false.


Example 1:

> Input: num = "1234"

> Output: false

> Explanation:
> 
> The sum of digits at even indices is 1 + 3 == 4, and the sum of digits at odd indices is 2 + 4 == 6.
Since 4 is not equal to 6, num is not balanced.

Example 2:
> Input: num = "24123"

> Output: true

> Explanation:
> 
> The sum of digits at even indices is 2 + 1 + 3 == 6, and the sum of digits at odd indices is 4 + 2 == 6.
Since both are equal the num is balanced.


Constraints:
- 2 <= num.length <= 100
- num consists of digits only

# 풀이
홀수 인덱스의 숫자와 짝수 인덱스의 숫자의 합이 같은지를 반환하는 문제이다.

인덱스가 짝수인 경우에는 sum에다가 더하고, 홀수인 경우에는 빼주면서 합이 0이 되는지를 확인하여 반환했다.