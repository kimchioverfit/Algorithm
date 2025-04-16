/**
* https://school.programmers.co.kr/learn/courses/30/lessons/17682
*/

class Solution {
    public int solution(String dartResult) {

	    int answer = 0;
	    
	    int pre = 0;
	    int cur = 0;
	    int num = 0;
	    
	    for (int i = 0; i < dartResult.length(); i++) {
	    	char c = dartResult.charAt(i);
	    	
	    	if ('0' <= c && c <= '9') {
	    		if (c == '1') {
	    			num = 1;
	    		}
	    		else if (c == '0') {
	    			if (num == 1) {
	    				num = 10;
	    			}
	    			else {
	    				num = 0;
	    			}
	    		}
	    		else {
	    			num = c - '0';
	    		}
	    	}	    	
	    	else if (c == 'S' || c == 'D' || c == 'T') {
	    		answer += pre;
	    		pre = cur;
	    		cur = 0;
	    		
		    	if (c == 'S') {
		    		cur = num;
		    	}
		    	else if (c == 'D') {
		    		cur = num * num;
		    	}
		    	else if (c == 'T') {
		    		cur = num * num * num;
		    	}	    			
	    		num = 0;
    		}
	    	else {
		    	if (c == '*') {
		    		pre *= 2;
		    		cur *= 2;	    		
		    	}
		    	else if (c == '#') {
		    		cur *= -1;
		    	}
	    	}
	    }
	    
	    return answer + pre + cur;
    }
}