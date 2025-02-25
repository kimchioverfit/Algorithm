/** https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

	static int minDiff = Integer.MAX_VALUE;
	
    public int minDiffInBST(TreeNode root) {
    	minDiff = Integer.MAX_VALUE;
    	dfs(root);
    	return minDiff;
    }
    
    public Tuple dfs(TreeNode root) {
    	if (minDiff == 1) {
    		return null;
    	}
    	
    	Tuple left = null;
    	Tuple right = null;

    	int leftMin = root.val;
    	int leftMax = root.val;
    	int rightMin = root.val;
    	int rightMax = root.val;
    	
    	if (root.left != null) {
    		left = dfs(root.left);
    		if (left == null) {
    			return null;
    		}
            leftMin = left.min;
    		leftMax = left.max;
    		minDiff = minDiff < root.val - leftMax ? minDiff : root.val - leftMax;
    	}
    	if (root.right != null) {
    		right = dfs(root.right);
    		if (right == null) {
    			return null;
    		}
    		rightMin = right.min;
            rightMax = right.max;
    		minDiff = minDiff < rightMin - root.val ? minDiff : rightMin - root.val;
    	}
    	
    	return new Tuple(leftMin, rightMax);
    }
    
    public class Tuple {
    	int min;
    	int max;
    	
    	public Tuple(int min, int max) {
    		this.min = min;
    		this.max = max;
    	}
    }
}