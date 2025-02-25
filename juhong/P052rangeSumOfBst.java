/** https://leetcode.com/problems/range-sum-of-bst/
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
    
	static int nodeSum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
    	nodeSum = 0;
    	dfs(root, low, high);
		return nodeSum;
    }

    public void dfs(TreeNode node, int low, int high) {
    	boolean lowFlag = false;
    	boolean highFlag = false;
    	
    	if (low <= node.val) {
    		lowFlag = true;
    		if (node.left != null) {
    			dfs(node.left, low, high);
    		}
    	}
    	if (node.val <= high) {
    		highFlag = true;
    		if (node.right != null) {
        		dfs(node.right, low, high);    			
    		}
    	}
    	if (lowFlag && highFlag) {
    		nodeSum += node.val;
    	}
    }

}