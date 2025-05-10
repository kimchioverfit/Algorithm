/* https://school.programmers.co.kr/learn/courses/30/lessons/150365 */

class Solution {

	public static int N = 0;
	public static int M = 0;

	public static int R = 0;
	public static int C = 0;
	
	public static int K = 0;
	public static String ANSWER = null;
	public static String ANSWER_RETURN = null;
	
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
    	ANSWER = null;
    	ANSWER_RETURN = null;
        N = n;
        M = m;
        R = r - 1;
        C = c - 1;
        K = k;

    	if (abs(x - 1 - R) + abs(y - 1 - C) > K) {
    		return "impossible";
    	}
    	
    	move(x - 1, y - 1, new StringBuilder());
    	
    	if (ANSWER == null) {
    		return "impossible";
    	}
    	
    	int left = k - ANSWER.length();
    	
    	if (left % 2 == 1) {
    		return "impossible";
    	}
    	
    	if (left == 0) {
    		return ANSWER;
    	}
    	
        ANSWER_RETURN = String.valueOf(ANSWER);
        while (ANSWER_RETURN.length() != k) {
            moveFromStart(R, C, new StringBuilder(ANSWER_RETURN), true);
            if (ANSWER_RETURN.equals(ANSWER)) {
        		return "impossible";
            }
            ANSWER = String.valueOf(ANSWER_RETURN);
        }
        
    	return ANSWER;
    }
    
    private void moveFromStart(int i, int j, StringBuilder sb, boolean isStart) {
    	
        if (!ANSWER_RETURN.equals(ANSWER)) {
        	return;
        }

        int cnt = sb.length();
        
    	if (cnt > K) {
    		return;
    	}
    	
    	if (abs(i - R) + abs(j - C) > K - cnt) {
    		return;
    	}
        
    	if (i == R && j == C && !isStart) {
    		ANSWER_RETURN = sb.toString();
    		return;
    	}
        
    	if (i + 1 < N) {
        	sb.append("d");
        	moveFromStart(i + 1, j, sb, false);
        	sb.deleteCharAt(cnt);		
    	}
    	if (j - 1 >= 0) {
    		sb.append("l");
    		moveFromStart(i, j - 1, sb, false);
    		sb.deleteCharAt(cnt);
    	}
    	if (j + 1 < M) {
    		sb.append("r");
    		moveFromStart(i, j + 1, sb, false);
    		sb.deleteCharAt(cnt);
    	}    	
    	if (i - 1 >= 0) {
        	sb.append("u");
        	moveFromStart(i - 1, j, sb, false);
        	sb.deleteCharAt(cnt);
    	}
    }
    
    private void move(int i, int j, StringBuilder sb) {
    	if (ANSWER != null) {
            return;
    	}

		String result = sb.toString();
    	int cnt = sb.length();
    	if (cnt > K) {
    		return;
    	}
    	
    	if (abs(i - R) + abs(j - C) > K - cnt) {
    		return;
    	}
    	
    	if (i == R && j == C) {
            ANSWER = result;
    		return;
    	}

    	if (i + 1 < N) {
        	sb.append("d");
        	move(i + 1, j, sb);
        	sb.deleteCharAt(cnt);		
    	}
    	if (j - 1 >= 0) {
    		sb.append("l");
    		move(i, j - 1, sb);
    		sb.deleteCharAt(cnt);
    	}
    	if (j + 1 < M) {
    		sb.append("r");
    		move(i, j + 1, sb);
    		sb.deleteCharAt(cnt);
    	}    	
    	if (i - 1 >= 0) {
        	sb.append("u");
        	move(i - 1, j, sb);
        	sb.deleteCharAt(cnt);
    	}
    }
    
    private int abs(int num) {
    	return num >= 0 ? num : num * -1;
    }
    
    
    
}