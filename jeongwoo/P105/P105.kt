class Solution {
    fun makeTree(preorder: List<Int>, inorder: List<Int>, rootValue: Int?): TreeNode? {
        if(rootValue == null) return null

        if(preorder.size == 1) return TreeNode(preorder[0])

        val rootIndex = inorder.indexOf(rootValue)
        val leftInorder = inorder.slice(0 until rootIndex)
        val rightInorder = inorder.slice(rootIndex + 1 until inorder.size)

        val leftPreorder = preorder.slice(1 until (leftInorder.size + 1))
        val rightPreorder = preorder.slice((leftInorder.size + 1) until preorder.size)

        return TreeNode(rootValue).apply {
            this.left = if(leftPreorder.size >= 1) {
                makeTree(leftPreorder, leftInorder, leftPreorder[0])
            } else null
            this.right = if(rightPreorder.size >= 1) {
                makeTree(rightPreorder, rightInorder, rightPreorder[0])
            } else null
        }
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return makeTree(preorder.toList(), inorder.toList(), preorder[0])
    }
}
