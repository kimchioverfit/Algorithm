/** https://leetcode.com/problems/different-ways-to-add-parentheses/
 */

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
    	HashMap<Tuple, List<Integer>> map = new HashMap<>();
        
        String[] nums = expression.split("[-*+]+");
        String[] signs = expression.split("[0-9]+");
                
        for (int length = 0; length < nums.length; length++) {
        	for (int index = 0; index < nums.length - length; index++) {
    			ArrayList<Integer> target = new ArrayList<>();
        		if (length == 0) {
        			target.add(Integer.valueOf(nums[index]));
        		}
        		else {
        			for (int j = index; j < index + length; j++) {
        				List<Integer> left = map.get(new Tuple(index, j));
        				List<Integer> right = map.get(new Tuple(j + 1, index + length));
        				String sign = signs[j + 1];
        				
    					for (int leftVal : left) {
    						for (int rightVal : right) {
    	        				if ("+".equals(sign)) {
    	        					target.add(leftVal + rightVal);
    	        				}
    	        				else if ("-".equals(sign)) {
    	        					target.add(leftVal - rightVal);    	        					
    	        				}
    	        				else {
    	        					target.add(leftVal * rightVal);    	  
    	        				}    							
    						}
    					}
    					
        			}
        		}
        		map.put(new Tuple(index, index + length), target);
        	}
        }
        return map.get(new Tuple(0, nums.length - 1));
    }

    class Tuple {
    	int start;
    	int end;
    	
    	Tuple(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		// TODO Auto-generated method stub
    		Tuple t = (Tuple) obj;
    		if (this.end == t.end && this.start == t.start) {
    			return true;
    		}
    		return false;    		
    	}
    	
    	@Override
    	public int hashCode() {
    		return Objects.hash(this.start, this.end);
    	}
    }    
}