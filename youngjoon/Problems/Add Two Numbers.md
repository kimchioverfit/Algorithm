---
layout: post
title: 2. Add Two Numbers.md
category: leetcode
date: 2024-12-18 16:18:45 +0900
description: https://leetcode.com/problems/add-two-numbers/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---

            
# 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. 

The digits are stored in reverse order, and each of their nodes contains a single digit.

Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, 

except the number 0 itself.


<img src="../imgs/addtwonumber1.jpg" alt="addtwonumber1" width="300"/>

    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]

Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

<br>

    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

# Solution

```cpp
#include <vector>
using namespace std;

//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr && l2 == nullptr) {
            return nullptr;
        }
        
        // Sum current digits
        int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0);
        
        // Check if next node exists, or if carry should be propagated
        if (l1 && l1->next) {
            l1->next->val += sum / 10; // Add carry to the next node
        } else if (l2 && l2->next) {
            l2->next->val += sum / 10; // Add carry to the next node
        } else if (sum >= 10) {
            // Create a new node for carry if no next nodes exist
            if (l1) {
                l1->next = new ListNode(sum / 10);
            } else if (l2) {
                l2->next = new ListNode(sum / 10);
            } else {
                return new ListNode(sum % 10, new ListNode(sum / 10));
            }
        }
        
        // Create the current node
        ListNode* node = new ListNode(sum % 10);
        
        // Recursively calculate the next node
        node->next = addTwoNumbers(l1 ? l1->next : nullptr, l2 ? l2->next : nullptr);
        
        return node;
    }
};
```

문제를 풀다가 마지막 node를 어떻게 할지 고민하다가 시간을 낭비했는데,

맨 위의 생성자 주석 잘 읽으면 간단히 해결 가능한 문제였음. 주의하자.
