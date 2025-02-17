/** https://leetcode.com/problems/longest-univalue-path/description/
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
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        if (root != null) {
            backTrack(root);
        }
        return max;
    }

    public int backTrack(TreeNode cur) {
        int left = 0;
        int right = 0;

        if (cur.left != null) {
            left = backTrack(cur.left);
            if (cur.left.val == cur.val) {
                left += 1;
            }
            else {
                left = 0;
            }
        }
        if (cur.right != null) {
            right = backTrack(cur.right);
            if (cur.right.val == cur.val) {
                right += 1;
            }
            else {
                right = 0;
            }
        }
        max = left + right > max ? left + right : max;

        return left > right ? left : right;
    }
}