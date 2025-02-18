/** https://leetcode.com/problems/balanced-binary-tree/
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
    static boolean result = false;
    public boolean isBalanced(TreeNode root) {
        result = true;
        backTrack(root);
        return result;
    }

    public int backTrack(TreeNode root) {
        if (result == false) {
            return 0;
        }
        if (root == null) {
            return 0;
        }

        int left = backTrack(root.left);
        int right = backTrack(root.right);

        if (left - right > 1 || left - right < -1) {
            result = false;
        }
        return (left > right ? left : right) + 1;
    }
}