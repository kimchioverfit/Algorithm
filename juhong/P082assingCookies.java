/** https://leetcode.com/problems/assign-cookies/
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ret = 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gIndex = 0;
        int gLength = g.length;
        int sIndex = 0;
        int sLength = s.length;
        
        while (gIndex < gLength && sIndex < sLength) {
        	if (g[gIndex] <= s[sIndex]) {
        		gIndex += 1;
        		sIndex += 1;
        		ret += 1;
        	}
        	else {
        		while (sIndex < sLength && g[gIndex] > s[sIndex]) {
        			sIndex += 1;
        		}
        	}
        }
        
        return ret;
    }
}