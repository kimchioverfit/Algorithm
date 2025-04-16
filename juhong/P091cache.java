/**
* https://school.programmers.co.kr/learn/courses/30/lessons/17680#
*/

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int start = 0;
        int end = 0;
        
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        while (end < cities.length) {
            String city = cities[end];
            int endCnt = map.getOrDefault(city, 0);
            map.put(city, endCnt + 1);
            
            if (set.contains(city)) {
                answer += 1;
            }
            else {
                set.add(city);
                while (set.size() > cacheSize) {
                    int startCnt = map.get(cities[start]);
                    if (--startCnt == 0) {
                        set.remove(cities[start]);
                    }
                    map.put(cities[start], startCnt);
                    start += 1;
                }
                answer += 5;
            }
            end += 1;
        }
        
        return answer;
    }
}