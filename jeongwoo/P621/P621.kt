class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        // task, next available time, left count
        val pq = PriorityQueue<Triple<Char, Int, Int>>() {
            a, b -> if(a.second == b.second) b.third - a.third else a.second - b.second
        }

        val counts = IntArray(26) { 0 }

        for(task in tasks) {
            counts[task - 'A']++
        }

        for(i in 0..25) {
            if(counts[i] != 0) {
                pq.offer(Triple('A' + i, 0, counts[i]))
            }
        }

        var answer = 0
        while(!pq.isEmpty()) {
            val (task, time, count) = pq.poll()

            if(time > answer) {
                answer += (time - answer)
            }

            answer++

            while(!pq.isEmpty()) {
                val next = pq.poll()

                if(next.second >= answer) {
                    pq.offer(next)
                    break
                }

                pq.offer(Triple(next.first, answer, next.third))
            }

            if(count > 1) {
                pq.offer(Triple(task, answer + n, count - 1))
            }
        }

        return answer
    }
}
