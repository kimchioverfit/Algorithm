---
layout: post
title: 1768. Merge Strings Alternately
category: leetcode
date: 2025-01-24 21:42:00 +0900
description: https://leetcode.com/problems/merge-strings-alternately/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---


# 1768. Merge Strings Alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 
```
Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
```

```
Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   
```

```
Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
```

# Solution 
```cpp
class Solution {
public:
string results;
bool flag;
    string mergeAlternately(string word1, string word2) {
        mergeString(word1,word2);
        return results;
    }
    void mergeString(string word1, string word2){
        if(word1.size() > word2.size()) flag = true;
        int minSize = (word1.size() < word2.size()) ? word1.size() : word2.size();
        int maxSize = (word1.size() > word2.size()) ? word1.size() : word2.size();
        for(int i=0; i<minSize; i++){
            results += word1[i];
            results += word2[i];
        }
        if(flag){
            for(int i=minSize; i<maxSize; i++){
                results += word1[i];
            }
        }
        else{
            for(int i=minSize; i<maxSize; i++){
                results += word2[i];
            }
        }

    }
};
```

풀리긴 하지만 쓸모없는 과정이 몇 개 있다.

우선, member var를 만들어서 이용하는 것 보다, 함수내에서 선언하여 parameter로 전달하는 것이 더 빠름.

그리고, 


```cpp
if(word1.size() > word2.size()) flag = true;
        int minSize = (word1.size() < word2.size()) ? word1.size() : word2.size();
        int maxSize = (word1.size() > word2.size()) ? word1.size() : word2.size();
```

여기서 이렇게 체크를 해주는 것이 불필요함. 


# Solution 2 

```cpp
class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int i = 0, j = 0;
        string result;
        while (i < word1.size() && j < word2.size()) {
            result += word1[i];
            result += word2[j];
            i++;
            j++;
        }
        while (i < word1.size()) {
            result += word1[i];
            i++;
        }
        while (j < word2.size()) {
            result += word2[j];
            j++;
        }
        return result;
    }
};

```
여기서는 
```cpp
while (i < word1.size() && j < word2.size()) 
```

이런 식으로 조건을 걸어주는데, 이렇게 하면 둘이 겹치는 길이까지만 동작가능.