/** 344. Reverse String
https://leetcode.com/problems/reverse-string/
 */

class Solution {
    public void reverseString(char[] s) {
        int length = s.length - 1;
        char temp = 0;
        for (int i = 0; i <= length / 2; i++) {
            temp = s[i];
            s[i] = s[length - i];
            s[length - i] = temp;
        }
    }
}