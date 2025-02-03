/** 5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
 */
class Solution {
    public String longestPalindrome(String s) {

        String even = getPl(s, 0, 1);
        String odd = getPl(s, 0, 0);

        return even.length() > odd.length() ? even : odd;
    }

    private String getPl(String s, int left, int right) { // O(n^2)
        String result = "";
        while (right < s.length()) { // O(n)
            if (s.charAt(left) == s.charAt(right)) {
                while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) { // O(n)
                    if (!isPl(s, left - 1, right + 1)) {
                        break;
                    }
                    left -= 1;
                    right += 1;
                }
                result = result.length() < s.substring(left, right + 1).length() ? s.substring(left, right + 1) : result;
            }

            left += 1;
            right += 1;
        }
        return result;
    }

    private boolean isPl(String s, int left, int right) {
        String p = s.substring(left, right + 1);
        StringBuilder sb = new StringBuilder(p);
        return sb.reverse().toString().equals(p);
    }
}