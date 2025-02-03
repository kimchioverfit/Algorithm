/** 49. Group Anagrams
https://leetcode.com/problems/group-anagrams/
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = null;
        char[] charArray = null;
        String orderedStr = null;

        for (String str : strs) { // O(n)
            charArray = str.toCharArray();
            Arrays.sort(charArray); // O(m * log m) (0 <= m <= 100) 
            orderedStr = new String(charArray);

            if (map.containsKey(orderedStr)) { // O(1)
                list = map.get(orderedStr);
            }
            else {
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(orderedStr, list);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}