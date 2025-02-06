class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int length = s.length();
    	if (length == 0) {
    		return 0;
    	}
    	
    	int start = 0;
    	int end = 1;
    	int ret = 1;
    	int flag = 0;
    	HashSet<Character> set = new HashSet<>();
    	
    	set.add(s.charAt(start));
    	
    	while (end < length) {
    		flag = 0;
    		char c = s.charAt(end);
    		
    		while (set.contains(c) && start < end) {
    			set.remove(s.charAt(start));
    			start += 1;
    		}
    		
    		set.add(c);
    		end += 1;
    		ret = ret > (end - start) ? ret : (end - start);
    		
    		while(end < length && c == s.charAt(end)) {
    			flag = 1;
    			end += 1;
    		}
    		if (flag == 1) {
    			start = end - 1;
    			set = new HashSet<>();
    			set.add(c);
    		}
    	}
    	
		return ret;
    }
}