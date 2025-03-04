/** https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = null;
        TreeNode cur = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int pre : preorder) {
            cur = new TreeNode(pre);
            if (result == null) {
                result = cur;
            }
            else {
                TreeNode parent = null;
                while(!stack.isEmpty()) {
                    if (map.get(stack.peek().val) > map.get(pre)) {
                        if (stack.peek().left != null) {
                            parent.right = cur;
                        }
                        else {
                            stack.peek().left = cur;
                        }
                        break;
                    }
                    else {
                        parent = stack.pop();                        
                    }
                }
                if (stack.isEmpty()) {
                    parent.right = cur;
                }
            }
            stack.push(cur);
        }
        return result;
    }
}