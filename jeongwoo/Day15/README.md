# [문제](https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/)

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

 

Example 1:
> Input: head = [1,8,9]

> Output: [3,7,8]

> Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:
> Input: head = [9,9,9]

> Output: [1,9,9,8]
> Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

- The number of nodes in the list is in the range [1, 10^4]
- 0 <= Node.val <= 9
- The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

# 풀이
연결리스트에 있는 모든 값들을 차례대로 이은 다음에 2를 곱한 수를 똑같은 방식으로 새로운 연결리스트로 만드는 문제이다.

먼저 연결리스트를 탐색하며 모든 숫자를 새로운 LinkedList에 넣어주고, 원본의 뒷자리부터 하나씩 가져와서 새로운 노드를 만들어갔다.

2를 곱했을 때, 10이 넘으면 다음 자리로 넘겨주는 방식으로 쭉쭉 이어가면 해결
