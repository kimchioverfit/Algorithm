/** https://leetcode.com/problems/climbing-stairs/
 */

class Solution {
	
	public static int[] ret = new int[46];
	
    public int climbStairs(int n) {
    	if (n == 0) {
    		return 0;
    	}
    	else if (n == 1) {
    		return 1;
    	}
    	else if (n == 2) {
    		return 2;
    	}
    	
    	if (ret[n] != 0) {
    		return ret[n];
    	}
    	
        ret[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return ret[n];
    }
}