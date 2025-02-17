/** https://leetcode.com/problems/merge-two-binary-trees/
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            if (root2 == null) {
                return root1;
            }
            else {
                return root2;
            }
        }
        else {
            if (root2 == null) {
                return root1;
            }
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();

            cur1.val += cur2.val;

            if (cur1.left == null) {
                if (cur2.left == null) {
                    // nothing
                }
                else {
                    cur1.left = cur2.left;
                }
            }
            else {
                if (cur2.left == null) {
                    // nothing
                }
                else {
                    stack1.push(cur1.left);
                    stack2.push(cur2.left);
                }
            }

            if (cur1.right == null) {
                if (cur2.right == null) {
                    // nothing
                }
                else {
                    cur1.right = cur2.right;
                }
            }
            else {
                if (cur2.right == null) {
                    // nothing
                }
                else {
                    stack1.push(cur1.right);
                    stack2.push(cur2.right);
                }
            }
        }
        return root1;

    }
}