/*
https://school.programmers.co.kr/learn/courses/30/lessons/258712
*/

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int length = friends.length;
        
        int[] setCount = new int[length];
        int[] getCount = new int[length];
                
        int[][] arr = new int[length][length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
        	map.put(friends[i], i);
        }
        
        for (String gift : gifts) {
        	String[] relation = gift.split(" ");
        	int from = map.get(relation[0]);
        	int to = map.get(relation[1]);
        	arr[from][to] += 1;
        	
        	getCount[to] += 1;
        	setCount[from] += 1;
        }
        
        for (int i = 0; i < length; i++) {
        	int iIndex = setCount[i] - getCount[i];
			int get = 0;
        	for (int j = 0; j < length; j++) {
        		if (i == j) continue;
        		
        		if (arr[i][j] > arr[j][i]) {
        			get += 1;
        		}
        		else if (arr[i][j] < arr[j][i]) {
        			continue;
        		}
        		else {
        			int jIndex = setCount[j] - getCount[j];
        			if (iIndex > jIndex) {
        				get += 1;
        			}
        		}
        	}
        	answer = answer < get ? get : answer;
        }        
        
        return answer;
    }
}