# [문제](https://leetcode.com/problems/count-complete-tree-nodes/description/)

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:
> Input: root = [1,2,3,4,5,6]

> Output: 6


Example 2:

> Input: root = []

> Output: 0


Example 3:

> Input: root = [1]

> Output: 1
 

Constraints:
- The number of nodes in the tree is in the range [0, 5 * 10^4].
- 0 <= Node.val <= 5 * 10^4
- The tree is guaranteed to be complete.

# 풀이
root부터 번호를 매겨가면서 가장 큰 번호가 나올때까지 이진 트리를 탐색했다.

릿코드에 따르면 시간 복잡도는 O(N)이라고 하는데.. 이거보다 짧게 하려면 그냥 null이 아닐때 카운트를 더하는 방법으로 푸는 듯하다.
