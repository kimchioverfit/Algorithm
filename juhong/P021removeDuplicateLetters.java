/**
 * https://leetcode.com/problems/remove-duplicate-letters/submissions/1525398100/
 */

import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = c - 'a';

            if (seen[n]) {
                continue;
            }

            while(result.length() > 0 && c < result.charAt(result.length() - 1) && lastIndex[result.charAt(result.length() - 1) - 'a'] > i) {
                seen[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(c);
            seen[n] = true;
        }
        return result.toString();
    }
}