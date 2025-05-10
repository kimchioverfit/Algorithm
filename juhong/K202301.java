/* https://school.programmers.co.kr/learn/courses/30/lessons/150370 */

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> answerArr = new ArrayList<>();
        
        String[] yyyyMMdd = today.split("\\.");
        int todayInt = Integer.parseInt(yyyyMMdd[0]) * (28 * 12) + Integer.parseInt(yyyyMMdd[1]) * 28 + Integer.parseInt(yyyyMMdd[2]);
        
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
        	String[] termArr = term.split(" ");
        	termMap.put(termArr[0], Integer.parseInt(termArr[1]) * 28);
        }
        
        for (int i = 0; i < privacies.length; i++) {
        	
        	String[] privacyArr = privacies[i].split(" ");
        	String[] privacyYyyyMMdd = privacyArr[0].split("\\.");
            int privacyInt = Integer.parseInt(privacyYyyyMMdd[0]) * (28 * 12) + Integer.parseInt(privacyYyyyMMdd[1]) * 28 + Integer.parseInt(privacyYyyyMMdd[2]);
            
            if (todayInt >= privacyInt + termMap.get(privacyArr[1])) {
            	answerArr.add(i);
            }
        }
        
        answer = new int[answerArr.size()];
        
        for (int i = 0; i < answerArr.size(); i++) {
        	answer[i] = answerArr.get(i) + 1;
        }
        
        return answer;
    }
}
