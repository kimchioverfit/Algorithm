/** https://leetcode.com/problems/fibonacci-number/
 */

class Solution {
	private static int[] fibArr = new int[31];
	
    public int fib(int n) {
    	if (n == 0) {
    		return 0;
    	}
    	else if (n == 1) {
    		return 1;
    	}
    	
    	if (fibArr[n] == 0) {
    		fibArr[n] = fib(n - 1) + fib(n - 2);
    	}
    	return fibArr[n];
    }
}