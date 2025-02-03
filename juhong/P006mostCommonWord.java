/** 819. Most Common Word
https://leetcode.com/problems/most-common-word/
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> counterMap = new HashMap<>();
    
        Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };

        String sentence = paragraph.toLowerCase().replaceAll("[!?',;. ]", " ").replaceAll("\\s+", " ");
        for (String word : sentence.split(" ")) {
            if (bannedSet.contains(word)) {
                continue;
            }

            if (counterMap.containsKey(word)) {
                counterMap.put(word, counterMap.get(word) + 1);
            }
            else {
                counterMap.put(word, 1);
            }
        }

        Entry<String, Integer> maxEntry = Collections.max(counterMap.entrySet(), comparator);

        return maxEntry.getKey();
    }

}