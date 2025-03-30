/** https://leetcode.com/problems/utf-8-validation/
 */
class Solution {
    public boolean validUtf8(int[] data) {
    	int leftCnt = 0;
    	
    	for (int element : data) {
        	String binary = Integer.toBinaryString(element);
        	if (leftCnt == 0) {
        		if (binary.length() == 8) {            		
                	if (binary.startsWith("11110")) {
                		leftCnt = 3;
                	}
                	else if (binary.startsWith("1110")) {
                		leftCnt = 2;
                	}
                	else if (binary.startsWith("110")) {            		
                		leftCnt = 1;
                	}
                	else {
                		return false;
                	}
        		}
            	else {
            		leftCnt = 0;
            	}
        	}
        	else {
        		if (!(binary.startsWith("10") && binary.length() == 8)) {
        			return false;
        		}
        		leftCnt -= 1;
        	}
    	}    	
    	
		return leftCnt == 0 ? true : false;
    }
}