/** https://leetcode.com/problems/gas-station/
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        
        int[] sum = new int[n];
        
        // [3, -2, 2, -1, 1, 0, 300]
        for (int i = 0; i < n; i++) {
        	sum[i] = gas[i] - cost[i];
        	total += sum[i];
        }
        
        if (total < 0) {
        	return -1;
        }
        
        int start = 0;
        int end = 0;
        total = 0;

        while (start < n) {
        	total += sum[end];
        	end += 1;
        	if (end >= n) {
        		end -= n;
        	}        	
        	if (total < 0) {
        		total = 0;
        		
        		if (start > end) {
        			break;
        		}
        		start = end;
        	}
        	else {
        		if (start == end) {
        			return start;
        		}
        	}
        }
        
        return -1;
    }
}