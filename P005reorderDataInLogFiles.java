/** 937. Reorder Data in Log Files
https://leetcode.com/problems/reorder-data-in-log-files/description/
*/
import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digitLogs = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        int index = -1;
        char firstKey = 0;
        String key = "";
        String value = "";

        SortedMap<String, SortedSet<String>> map = new TreeMap<>();
        SortedSet<String> set = null;

        for (String log : logs) { // O(n)
            index = log.indexOf(" ");
            key = log.substring(index + 1);
            value = log.substring(0, index);
            firstKey = key.charAt(0);

            if ('0' <= firstKey && firstKey <= '9') {
                digitLogs.add(log);
                continue;
            }

            if(map.containsKey(key)) {
                set = map.get(key);
            }
            else {
                set = new TreeSet<String>();
            }
            set.add(value); // O(log n)
            map.put(key, set); // O(log n)
        }

        for (String sKey : map.keySet()) {
            for (String sValue : map.get(sKey)) {
                result.add(sValue + " " + sKey);
            }
        }
        result.addAll(digitLogs);
        return result.toArray(new String[0]); 
    }
}