# [문제](https://leetcode.com/problems/excel-sheet-column-number/description/)

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:

> Input: columnTitle = "A"
> 
> Output: 1

Example 2:
> Input: columnTitle = "AB"
> Output: 28

Example 3:

> Input: columnTitle = "ZY"
> 
> Output: 701


Constraints:
- 1 <= columnTitle.length <= 7
- columnTitle consists only of uppercase English letters.
- columnTitle is in the range ["A", "FXSHRXW"].

# 풀이
엑셀의 컬럼이 몇번째인지 계산하는 문제이다. 

제일 뒷자리 문자부터 시작해 'A'의 아스키 코드 값과 비교하며 값을 계산해주면 된다.