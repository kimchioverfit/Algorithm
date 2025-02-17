/** https://leetcode.com/problems/diameter-of-binary-tree/description/
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
    static int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        backTrack(root);
        return max;
    }

    public int backTrack(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = backTrack(root.left) + 1;
        int right = backTrack(root.right) + 1;
        int cur = (left > right ? left : right);
        max = max > (left + right) ? max : (left + right);
        return cur;
    }
}