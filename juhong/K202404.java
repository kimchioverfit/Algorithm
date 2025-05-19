/*
https://school.programmers.co.kr/learn/courses/30/lessons/258707
*/

import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        HashMap<Integer, Integer> target = new HashMap<>();
        int[] distance = new int[n];
        
        for (int i = 0; i < n; i++) {
        	target.put(n + 1 - cards[i], i);
        }
        
        for (int i = 0; i < n; i++) {
        	distance[i] = target.get(cards[i]) - i;
        }
        
        int life = 0;
        
        for (int i = 0; i < n / 3; i++) {
        	if (distance[i] < 0) {
        		life += 1;
        	}
        }

        int requiresTwo = 0;
        
        for (int i = n / 3; i < n; i += 2) {
        	life -= 1;
        	
    		for (int j = i; j < i + 2; j++) {
    			if (distance[j] < 0) {
            		int targetIndex = distance[j] + j;
            		
            		if (targetIndex < n / 3) {
            			if (coin > 0) {
            				coin -= 1;
            				life += 1;
            			}
            		}
            		else {
            			requiresTwo += 1;
            		}
    			}
    		}
    		
    		if (life < 0) {
    			if (coin > 1 && requiresTwo > 0) {
    				requiresTwo -= 1;
    				coin -= 2;
    				life += 1;
    			}
    		}

        	if (life < 0) {
        		break;
        	}
        	else {
        		answer += 1;
        	}
        	
        }
        return answer;
    }
}