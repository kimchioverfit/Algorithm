/** https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

class Solution {
    public List<String> letterCombinations(String digits) {
    	ArrayList<String> result = new ArrayList<>();
    	
    	if (digits.length() == 0) {
    		return result;
    	}
    	
		HashMap<Character, char[]> map = new HashMap<>();

		map.put('2', new char[] {'a', 'b', 'c'});
		map.put('3', new char[] {'d', 'e', 'f'});
		map.put('4', new char[] {'g', 'h', 'i'});
		map.put('5', new char[] {'j', 'k', 'l'});
		map.put('6', new char[] {'m', 'n', 'o'});
		map.put('7', new char[] {'p', 'q', 'r', 's'});
		map.put('8', new char[] {'t', 'u', 'v'});
		map.put('9', new char[] {'w', 'x', 'y', 'z'});
		
		comb(digits, 0, "", result, map);
		
		return result;
    }

    public void comb(String digits, int index, String add, List<String> result, Map<Character, char[]> map) {
    	
    	if (index == digits.length()) {
    		result.add(add);
    		return;
    	}
    	
    	char[] dials = map.get(digits.charAt(index));
    	for (char dial : dials) {
        	comb(digits, index + 1, add + dial, result, map);
    	}
    }
}