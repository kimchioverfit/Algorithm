/** 125. Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
 */

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char startChar = 0;
        char endChar = 0;

        while ( start <= end ) {
            startChar = getAlpha(s.charAt(start));
            endChar = getAlpha(s.charAt(end));

            if (startChar == 0) {
                start += 1;
            }
            else if (endChar == 0) {
                end -= 1;
            }
            else if (startChar != endChar) {
                return false;
            }
            else {
                start += 1;
                end -= 1;
            }
        }
        return true;
    }

    private char getAlpha(char p) {
        if ('a' <= p && p <= 'z') {
            return p;
        }
        else if ('0' <= p && p <= '9') {
            return p;
        }
        else if ('A' <= p && p <= 'Z') {
            return (char) (p + 32);
        }
        else {
            return 0;
        }
    }
}