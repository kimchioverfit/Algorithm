/** https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDepth(TreeNode root) {
        int result = 0;
        Stack<Tuple> stack = new Stack<>();
        stack.push(new Tuple(root, 1));

        while (!stack.isEmpty()) {
            Tuple cur = stack.pop();
            if (cur.node == null) {
                continue;
            }
            result = result < cur.depth ? cur.depth : result;
            
            TreeNode left = cur.node.left;
            TreeNode right = cur.node.right;
            
            if (left != null) {
                stack.push(new Tuple(left, cur.depth + 1));
            }
            if (right != null) {
                stack.push(new Tuple(right, cur.depth + 1));
            }
        }
        return result;
    }

    class Tuple {
        TreeNode node;
        int depth;

        public Tuple(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}