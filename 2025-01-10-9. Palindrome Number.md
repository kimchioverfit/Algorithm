---
layout: post
title: 9. Palindrome Number.md
category: leetcode
date: 2025-01-10 09:29:00 +0900
description: https://leetcode.com/problems/palindrome-number/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

            
# 9. Palindrome Number

Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

# Solution

```cpp
class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0|| (x!=0 &&x%10==0)) return false;
        int sum=0;
        while(x>sum)
        {
            sum = sum*10+x%10;
            x = x/10;
        }
        return (x==sum)||(x==sum/10);
    }
};
```

어려운 문제가 아니라서 인터넷의 좋은 예시를 보고 개선하기로 했다.

아이디어는 나와 같았는데, 

```cpp
sum = (sum * 10) + (x % 10);
x = x / 10;
```

이런 식으로 역순 숫자 sum 을만들어서 진행하는 점이 인상깊었음. 

```cpp
return (x==sum)||(x==sum/10);
```

이 부분도 좋은 것 같다. 