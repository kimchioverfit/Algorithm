/** https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
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
    public static int nodeSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        nodeSum = 0;
        inorder(root);
        return root;
    }

    public void inorder(TreeNode node) {
        if (node.right != null) {
            inorder(node.right);
        }
        nodeSum += node.val;
        node.val = nodeSum;
        if (node.left != null) {
            inorder(node.left);
        }
    }
}