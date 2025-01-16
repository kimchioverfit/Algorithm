---
layout: post
title: 5. Longest Palindromic Substring.md
category: leetcode
date: 2024-12-18 16:18:45 +0900
description: https://leetcode.com/problems/longest-palindromic-substring/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

            
# 5. Longest Palindromic Substring


Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

```cpp
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";
        
        int start = 0, end = 0;
        
        // 중간을 기준으로 양쪽을 빼가면서 팰린드롬을 찾음
        for (int i = 0; i < s.size(); ++i) { //중심 이동
            int len1 = expandAroundCenter(s, i, i); // 홀수 길이 팰린드롬
            int len2 = expandAroundCenter(s, i, i + 1); // 짝수 길이 팰린드롬
            int len = max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substr(start, end - start + 1);
    }
    
private:
    int expandAroundCenter(const string& s, int left, int right) {
        while (left >= 0 && right < s.size() && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
};

```

기본적으로 좌우 index를 이용해서 좌우를 변경하면서 접근해야함. (2 Pointer)

expandAroundCenter 함수가 핵심인데, 이렇게 깔끔하게 접근하지못해서 실패함.

