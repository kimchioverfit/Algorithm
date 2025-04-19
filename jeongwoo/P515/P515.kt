class Solution {
    val answerMap = mutableMapOf<Long, Int>()

    fun largestValues(root: TreeNode?): List<Int> {
        largestValues(root, 1L, 1L)

        return answerMap.toList()
        .sortedWith(compareBy { it.first })
        .map {
            it.second
        }
    }

    fun largestValues(root: TreeNode?, index: Long, level: Long) {
        if(root == null) return

        if(answerMap[level] == null) {
            answerMap[level] = root.`val`
        } else {
            answerMap[level] = max(answerMap[level]!!, root.`val`)
        }

        largestValues(root.left, index * 2, level + 1)
        largestValues(root.right, (index * 2) + 1, level + 1)
    }
}
