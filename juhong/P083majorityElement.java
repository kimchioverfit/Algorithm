/** https://leetcode.com/problems/majority-element/
 */
import java.util.Map.Entry;

class Solution {
    public int majorityElement(int[] nums) {
    	int ret = 0;
    	int maxValue = 0;
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for (int num : nums) {
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	for (Entry<Integer, Integer> element : map.entrySet()) {
    		if (maxValue < element.getValue()) {
    			maxValue = element.getValue();
    			ret = element.getKey();
    		}
    	}
    	
    	return ret;
    }
}