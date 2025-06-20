class Solution {
    fun isCompleteTree(root: TreeNode?): Boolean {
        if(root == null) return true

        val isExistNode = BooleanArray(200) { false }
        var idx = 1

        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        isExistNode[idx] = true

        while(!queue.isEmpty()) {
            val cur = queue.poll()

            if(cur.left != null) {
                queue.offer(cur.left)
                isExistNode[idx * 2] = true
            }

            if(cur.right != null) {
                queue.offer(cur.right)
                isExistNode[idx * 2 + 1] = true
            }

            idx++
        }

        for(i in 1 until idx) {
            if(!isExistNode[i]) return false
        }

        return true
    }
}
