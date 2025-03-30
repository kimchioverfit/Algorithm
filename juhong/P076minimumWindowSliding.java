/** https://leetcode.com/problems/minimum-window-substring/description/
 */

import java.util.Map.Entry;

class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int cnt = 0;
            if (map.containsKey(c)) {
                cnt = map.get(c);
            }
            map.put(c, cnt + 1);
        }

        int start = 0;
        int end = 0;

        HashMap<Character, Integer> cur = new HashMap<>();

        while (start <= end && end <= s.length()) {
            int cnt = 0;
            boolean contained = isContained(map, cur);

            if (end == s.length()) {
                if (contained) {
                    if (result.length() == 0 || result.length() >= end - start + 1) {
                        result = s.substring(start, end);
                    }

                    if (start != end) {
                        char startChar = s.charAt(start);
                        cnt = cur.get(startChar);
                        cur.put(startChar, cnt - 1);
                    }
                }
                start += 1;
                continue;
            }

            if (contained) {
                if (result.length() == 0 || result.length() >= end - start + 1) {
                    result = s.substring(start, end);
                }
                char startChar = s.charAt(start);
                cnt = cur.get(startChar);
                cur.put(startChar, cnt - 1);
                start += 1;
            }
            else {
                char endChar = s.charAt(end);
                if (cur.containsKey(endChar)) {
                    cnt = cur.get(endChar);
                }
                cur.put(endChar, cnt + 1);
                end += 1;                
            }

        }

        if (s.length() < t.length()) {
            return "";
        }

        return result;
    }

    private boolean isContained(HashMap<Character, Integer> map, HashMap<Character, Integer> cur) {
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (!cur.containsKey(entry.getKey())) {
                return false;
            }
            if (cur.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
