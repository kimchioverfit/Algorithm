---
layout: post
title: 86. Partition List
category: leetcode
date: 2025-03-00 13:37:00 +0900
description: https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
status: failed
---

# 86. Partition List

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

> **Example 1**
>
> <img src="../imgs/86-1.jpg" alt="86-1" width="500"/>
> 
> Input: head = [1,4,3,2,5,2], x = 3
> 
> Output: [1,2,2,4,3,5]

> **Example 2**
> 
> Input: head = [2,1], x = 2
> 
> Output: [1,2]

### Solution(Failed)
```cpp
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* first = head;
        ListNode* prev = head;
        queue<int> q;
        while(head->next){
            if(head->val >= x){
                prev->next = head->next;
                q.push(head->val);
            }
            else{
                prev = head;
            }
            head = head->next;
        }
        while(!q.empty()){
            ListNode* dummy = new ListNode(q.front());
            q.pop();
            head->next = dummy;
            head = head->next;
        }
        return first;
    }
};
```

실패 이유 : 첫 시작 Node에서 바로 조건을 충족하는 경우를 고려 X

비효율 적인 부분 : 굳이 끊어내는 작업이 필요할까..

그냥 두 개로 분리해서 나중에 작은쪽에 합쳐버리는게 훨씬 쉽고 간단함.


### Solution
```cpp
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode lessHead(0);
        ListNode greaterHead(0);

        ListNode* less = &lessHead;
        ListNode* greater = &greaterHead;

        ListNode* current = head;
        while (current != nullptr) {
            if (current->val < x) {
                less->next = current;
                less = less->next;
            } else {
                greater->next = current;
                greater = greater->next;
            }
            current = current->next;
        }

        greater->next = nullptr;
        less->next = greaterHead.next;


        return lessHead.next;
    }
};
```