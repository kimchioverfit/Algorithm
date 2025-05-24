class Solution {
    var answer = 0

    fun maxDepth(root: Node?, level: Int) {
        if(root == null) return

        answer = max(answer, level + 1)

        for(node in root.children) {
            maxDepth(node, level + 1)
        }
    }

    fun maxDepth(root: Node?): Int {
        maxDepth(root, 0)

        return answer
    }
}
