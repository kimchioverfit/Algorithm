class Solution {
    fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
        val n = status.size
        val visited = BooleanArray(n) { false }
        var answer = 0

        val queue = LinkedList<Int>()
        val foundBoxes = mutableSetOf<Int>()
        val keySet = mutableSetOf<Int>()

        initialBoxes.forEach { box ->
            queue.offer(box)
            foundBoxes.add(box)

            if(status[box] == 1){
                keySet.add(box)
                visited[box] = true
            }
        }

        while (!queue.isEmpty()) {
            val cur = queue.poll()

            keys[cur].forEach { key ->
                keySet.add(key)

                if (foundBoxes.contains(key) && !visited[key]) {
                    queue.offer(key)
                    visited[key] = true
                }
            }

            containedBoxes[cur].forEach { box ->
                foundBoxes.add(box)

                if (keySet.contains(box) || status[box] == 1) {
                    if (!visited[box]) {
                        queue.offer(box)
                        visited[box] = true
                    }
                }
            }
        }

        for (i in 0 until n) {
            if (visited[i]) {
                answer += candies[i]
            }
        }

        return answer
    }
}
