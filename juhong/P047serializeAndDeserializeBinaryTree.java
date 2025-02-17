/** https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                sb.append("@").append("N");
                continue;
            }
            sb.append("@").append(cur.val);
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("@");
        TreeNode root = null;
        int index = 1;

        if (index > arr.length || "N".equals(arr[index])) {
            return root;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        root = new TreeNode( Integer.parseInt(arr[index]) );
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            
            String leftValue = arr[++index];
            String rightValue = arr[++index];

            if (!"N".equals(leftValue)) {
                TreeNode leftNode = new TreeNode( Integer.parseInt(leftValue) );
                cur.left = leftNode;
                queue.add(leftNode);
            }
            if (!"N".equals(rightValue)) {
                TreeNode rightNode = new TreeNode( Integer.parseInt(rightValue) );
                cur.right = rightNode;
                queue.add(rightNode);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));