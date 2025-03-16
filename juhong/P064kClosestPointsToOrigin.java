/** https://leetcode.com/problems/k-closest-points-to-origin/
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
    	int[][] result = new int[k][2];
    	ArrayList<Tuple> tuples = new ArrayList<>();
    	
    	for (int[] point : points) {
    		tuples.add(new Tuple(point[0], point[1]));
    	}
    	
    	Collections.sort(tuples, new Comparator<Tuple>() {

			@Override
			public int compare(Tuple o1, Tuple o2) {
				return o1.value - o2.value;
			}    		
    	});
    	
    	int idx = 0;
    	for (Tuple tuple : tuples) {
    		if (idx >= k) {
    			break;
    		}
    		result[idx][0] = tuple.x;
    		result[idx++][1] = tuple.y;
    	}
        
        
    	return result;
    }

	class Tuple {
		int x, y, value;
		
		public Tuple(int x, int y) {
			this.x = x;
			this.y = y;
			this.value = x * x + y * y;
		}		
	}
}