class Solution {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if(root1 == null && root2 == null) return true
        else if(root1 == null || root2 == null) return false

        return (root1.`val` == root2.`val`)
                && ((flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
                || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)))
    }
}