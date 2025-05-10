/* https://school.programmers.co.kr/learn/courses/30/lessons/150368 */
class Solution {
    static int maxMoney = 0;
    static int maxAssigned = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
    	maxMoney = 0;
    	maxAssigned = 0;
    	
        int[] answer = null;
        int m = emoticons.length;
        int[][] emoticonArr = new int[m][4];
        int[] visited = new int[m];
        
        for (int i = 0; i < users.length; i++) {
        	int num = users[i][0];
        	
        	if (num > 30) {
        		users[i][0] = 40;
        	}
        	else if (num > 20) {
        		users[i][0] = 30;
        	}
        	else if (num > 10) {
        		users[i][0]= 20;
        	}
        	else {
        		users[i][0] = 10;
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < 4; j++) {
        		emoticonArr[i][j] = emoticons[i] * (100 - 10 * (j + 1)) / 100;
        	}
        }
        dfs(0, visited, emoticonArr, users);
        
        answer = new int[] {maxAssigned, maxMoney};                
        return answer;
    }    
    
    public void dfs(int index, int[] visited, int[][] emoticonArr, int[][] users) {
    	if (index == visited.length) {
    		int[] heightList = new int[4];
    		for (int i = 0; i < index; i++) {
    			int height = visited[i];
    			heightList[height] += emoticonArr[i][height];
    		}
    		
    		for (int i = 3; i > 0; i--) {
    			heightList[i - 1] += heightList[i];
    		}
    		
    		int assigned = 0;
    		int money = 0;
    		
    		for (int i = 0; i < users.length; i++) {
    			for (int j = 3; j >= 0; j--) {
        			if ((j + 1) * 10 <= users[i][0]) {
        				if (heightList[j] >= users[i][1]) {
        					assigned += 1;
        				}
        				else {
        					money += heightList[j];
        				}
        				break;
        			}
    			}
    		}
    		
    		if (assigned > maxAssigned) {
    			maxAssigned = assigned;
    			maxMoney = money;
    		}
    		else if (assigned == maxAssigned) {
    			if (money > maxMoney) {
    				maxMoney = money;
    			}
    		}
    		    		
    		return;
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		visited[index] = i;
    		dfs(index + 1, visited, emoticonArr, users);
    	}
    }
}