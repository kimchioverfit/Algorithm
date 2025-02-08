/** https://leetcode.com/problems/number-of-islands/
 */

class Solution {
    public int numIslands(char[][] grid) {
        int result = 1;
        int m = grid.length; // 세로
        int n = grid[0].length; // 가로
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1') {
        			result += 1;
        			grid[i][j] = (char) (result + '0');
        			plague(grid, (char) (result + '0'), i, j, m, n);
        		}
        	}
        }
    	
    	return result - 1;
    }


    public void plague(char[][] grid, char result, int i, int j, int m, int n) {
		// 위
		if (i - 1 >= 0 && grid[i-1][j] == '1') {
			grid[i-1][j] = result;
			plague(grid, result, i-1, j, m, n);
		}
		// 아래
		if (i + 1 < m && grid[i+1][j] == '1') {
			grid[i+1][j] = result;
			plague(grid, result, i+1, j, m, n);			
		}
		// 왼쪽
		if (j - 1 >= 0 && grid[i][j-1] == '1') {
			grid[i][j-1] = result;
			plague(grid, result, i, j-1, m, n);
		}
		// 오른쪽
		if (j + 1 < n && grid[i][j+1] == '1') {
			grid[i][j+1] = result;
			plague(grid, result, i, j+1, m, n);
		}
		
    }
}