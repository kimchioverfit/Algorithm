class Solution {
    var answer = 0

    fun traversal(root: TreeNode?, parent: Int) {
        if(root == null) return

        answer = max(parent, answer)

        traversal(root.left, parent * 2)
        traversal(root.right, parent * 2 + 1)
    }

    fun countNodes(root: TreeNode?): Int {
        if(root == null) return 0

        traversal(root, 1)

        return answer
    }
}
