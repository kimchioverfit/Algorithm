/** https://leetcode.com/problems/longest-repeating-character-replacement/
 */

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == k) {
        	return k;
        }
        
        int length = s.length();
        int[] alphaArr = new int[26];
        char[] charArr = s.toCharArray();
        
        int start = 0;
        int end = 0;
        
        int result = 0;
        
        while (end < s.length()) {
        	int endAlpha = charArr[end] - 'A';
        	alphaArr[endAlpha] += 1;
        	
        	while ((start <= end && end == length - 1) || (start <= end && !allow(alphaArr, k))) {        		
        		if (length - 1 == end) {
        			if (result < end - start + 1) {
        				if (allow(alphaArr, k)) {
        					result = end - start + 1;
        				}
        			}
        		}
        		int startAlpha = charArr[start] - 'A'; 
        		alphaArr[startAlpha] -= 1;
        		start += 1;
        	}
        	
			if (result < end - start + 1) {
				result = end - start + 1;
			}        	
        	
    		end += 1;        		
        }
        
        return result;
    }
    
    private boolean allow(int[] alphaArr, int k) {
    	
    	int sum = 0;
    	int max = -1;
    	for (int i = 0; i < 26; i++) {
    		sum += alphaArr[i];
    		max = max < alphaArr[i] ? alphaArr[i] : max;
    	}
    	
    	
    	return (sum - max <= k);
    }
}