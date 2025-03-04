---
layout: post
title: 202. Happy Number
category: leetcode
date: 2025-03-04 21:16:00 +0900
description: https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
status: #failed or success
---

# 202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

> **Example 1**
> 
> Input: n = 19
> 
> Output: true
> 
> Explanation:
> 
> 12 + 92 = 82
> 
> 82 + 22 = 68
> 
> 62 + 82 = 100
> 
> 12 + 02 + 02 = 1

> **Example 2**
> 
> Input: n = 2
>
> Output: false


### Solution 
```cpp
class Solution {
public:
    bool isHappy(int n) {
        std::unordered_set<int> seen; // 방문한 숫자 저장

        while (n != 1 && seen.find(n) == seen.end()) {
            seen.insert(n);
            n = calculation(n);
        }

        return n == 1;
    }

private:
    int calculation(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
};
```