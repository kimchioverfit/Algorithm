# [문제](https://leetcode.com/problems/second-largest-digit-in-a-string/)

Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
An alphanumeric string is a string consisting of lowercase English letters and digits.

Example 1:
Input: 
> s = "dfa12321afd"

Output: 
> 2

Explanation: 
> The digits that appear in s are [1, 2, 3]. The second largest digit is 2.


Example 2:
Input: 
> s = "abc1111"

Output: 
> -1
> 
Explanation: 
> The digits that appear in s are [1]. There is no second largest digit.

Constraints:
- 1 <= s.length <= 500
- s consists of only lowercase English letters and digits.


# 풀이
소문자와 숫자로만 이루어진 문자열 내에서 두 번째로 큰 숫자를 찾는 문제이다.

두 번째로 큰 숫자의 값은 아래와 같은 상황에서 바뀐다.
- 가장 큰 숫자의 값이 바뀔 때
- 가장 큰 숫자의 값이 정해져 있고, 두 번째로 큰 숫자가 등장할 때

## 가장 큰 숫자의 값이 바뀔 때
예시
> maxDigit = 5
> 
> secondMaxDigit = -1
>
> i = 6

이 경우에는 기존 maxDigit 값을 secondMaxDigit에 넣어준다.

## 가장 큰 숫자의 값이 정해져 있고, 두 번째로 큰 숫자가 등장할 때
예시
> maxDigit = 5
> 
> secondMaxDigit = -1
> 
> i = 4

이 경우에는 secondMaxDigit 값을 i로 바꿔준다.