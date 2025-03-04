# [문제](https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description)
Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3^x.

 

Example 1:

> Input: n = 12

> Output: true

> Explanation: 12 = 3^1 + 3^2


Example 2:

> Input: n = 91

> Output: true

> Explanation: 91 = 3^0 + 3^2 + 3^4


Example 3:

> Input: n = 21
> Output: false
 
Constraints:

- 1 <= n <= 10^7

# 풀이
3의 x 제곱들로(x는 한번만 사용되어야 함) 해당 수를 만들 수 있는지 찾는 문제이다.

나는 set을 이용해서 모든 경우의 수를 검사했고, 해당 수를 만들어 낼 수 있으면 true를 리턴하도록 코드를 작성했다.

시간이 너무 오래걸려서 보니까 수학적으로 접근하면 시간을 엄청 단축할 수 있는 문제였다....
