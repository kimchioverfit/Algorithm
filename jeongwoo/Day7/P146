class LRUCache(_capacity: Int) {
    var map = mutableMapOf<Int, Int>()
    var pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
    var index = 0

    var capacity = 0

    init {
        capacity = _capacity
    }

    fun get(key: Int): Int {
        return map[key]?.let {
            if (it >= 0) {
                val target = pq.find { it.first == key }
                target?.let { pq.remove(target) }

                pq.offer(Pair(key, index++))

                it
            } else -1
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        if ((map[key] ?: -1) >= 0) {
            val target = pq.find { it.first == key }
            target?.let { pq.remove(target) }

            pq.offer(Pair(key, index++))
        } else {
            if (pq.size >= capacity) {
                val (leastKey, _) = pq.poll()

                map[leastKey] = -1
                pq.offer(Pair(key, index++))
            } else {
                pq.offer(Pair(key, index++))
            }
        }

        map[key] = value
    }
}
