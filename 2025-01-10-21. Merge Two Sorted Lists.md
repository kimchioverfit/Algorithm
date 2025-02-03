---
layout: post
title: 21. Merge Two Sorted Lists
category: leetcode
date: 2025-01-10 12:45:00 +0900
description: https://leetcode.com/problems/merge-two-sorted-lists/description/
img: leetcode.png # Add image post (optional)
fig-caption: # Add figcaption (optional)
---


# 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 
```
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

```
Example 2:
Input: list1 = [], list2 = []
Output: []
```

```
Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
```

# Solution (Failed)

```cpp
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (list1 && list2){
            ListNode * node = new ListNode ();
            ListNode * temp = new ListNode ();
            if(list1->val < list2-> val){
                int k= list1->val;
                list1->val = list2->val;
                list2->val = k;
            }

            temp->val = list2->val;
            temp->next = list2->next;
            list2->next = list1;
            mergeTwoLists(temp->next, list1->next);
        }
        else if (!list1 && list2){
            return list2;
        }
        else if (list1 && !list2){
            return list1;
        }
        return list2;
    }
};
```

난관 1. 오랜만에 해서 
```cpp
ListNode * node = new ListNode (); 
```
이런 식으로 동적할당 해주는 방법을 잊어버림;;;;

난관 2. 문제를 잘못 이해해서, 같은 사이즈의 node가 들어온다고 가정하고 풀어서 Exception에 많이 걸렸음.

난관 3. 문제에서 Sorted 부분을 읽지못하고 그냥 붙여주기만했음

난관 4. sorting을 단순히 두 값 비교만해서 넣다보니, 순서가 꼬여서 오답이 발생함.


# Solution 

```cpp
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (list1 == nullptr) {
            return list2;
        } else if (list2 == nullptr) {
            return list1;
        }
        // 여기 아래만 보면 됨
        // 현재 값 비교 후 재귀 호출을 통해 병합
        if (list1->val < list2->val) {
            list1->next = mergeTwoLists(list1->next, list2);
            return list1;
        } else {
            list2->next = mergeTwoLists(list1, list2->next);
            return list2;
        }
    }
};
```
재귀를 그대로 둔 상태로 푼 풀이. 

(More stack memory required) (스택메모리 요구량이 많다고해서 더 빠른건 아니다.)



# Solution (While loop)

```cpp
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {

        ListNode dummy;
        ListNode* tail = &dummy;
        
        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val < list2->val) {
                tail->next = list1;
                list1 = list1->next;
            } else {
                tail->next = list2;
                list2 = list2->next;
            }
            tail = tail->next;
        }
        
        if (list1 != nullptr) {
            tail->next = list1;
        } else {
            tail->next = list2;
        }
        
        return dummy.next;
    }
};
```



오늘의 교훈 : 

문제를 끝까지 제대로 읽자. 

읽는데 시간이 더 걸리더라도 정확하게 푸는게 중요 